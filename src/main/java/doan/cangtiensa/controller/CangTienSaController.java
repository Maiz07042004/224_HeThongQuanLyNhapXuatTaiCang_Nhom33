
package doan.cangtiensa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
//lan sau thay loi ni thi bo s
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import doan.cangtiensa.entity.Account;
import doan.cangtiensa.entity.Roles;
import doan.cangtiensa.model.AccountDTO;
import doan.cangtiensa.service.impl.AccountServiceImpl;
import doan.cangtiensa.service.impl.RolesServiceImpl;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Controller
@RequestMapping(value = { "/", "Ticket_Selling" })
public class CangTienSaController {

	@Autowired
	AccountServiceImpl accountService;


	@Autowired
	RolesServiceImpl rolesService;



	/* Gọi home page */

	int regisRole = 0;
	Roles roleNVCang = new Roles(2);
	Roles roleNVKD = new Roles(3);

	@GetMapping("/addExcel") // Or whatever URL you use to navigate to the upload page
    public String showAddExcelForm() {
        return "addExcel"; // This should resolve to your JSP file (e.g., /WEB-INF/views/addExcel.jsp)
    }
	@PostMapping("/themUserTuExcel")
	public String addUsersFromExcel(@RequestParam("file") MultipartFile file, Model model) {
		if (file.isEmpty()) {
			model.addAttribute("errorMessage", "Vui lòng chọn một file Excel để tải lên.");
			return "danhSachUser"; // Or a specific error page
		}

		List<Account> accountsToAdd = new ArrayList<>();
		int successCount = 0;
		int errorCount = 0;

		try (InputStream excelFile = file.getInputStream()) {
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet sheet = workbook.getSheetAt(0); // Assuming data is on the first sheet
			Iterator<Row> rowIterator = sheet.iterator();

			// Skip header row
			if (rowIterator.hasNext()) {
				rowIterator.next();
			}

			// Fetch roles once outside the loop for efficiency
			roleNVCang = rolesService.getRoleById(2); // Assuming ID 2 for 'NVCang'
			roleNVKD = rolesService.getRoleById(3); // Assuming ID 3 for 'NVKD'

			while (rowIterator.hasNext()) {
				Row currentRow = rowIterator.next();
				// Skip empty rows
				if (isRowEmpty(currentRow)) {
					continue;
				}

				Account account = new Account();
				try {
					// Assuming columns order: UserName, FullName, Address, DateOfBirth, Gender,
					// Password, PhoneNumber, IdentityCard, Email, RoleID
					// Adjust cell indices based on your Excel file's column order
					account.setUserName(getCellValue(currentRow.getCell(0)));
					account.setAccountID(account.getUserName()); // AccountID often derived from UserName or generated

					account.setFullName(getCellValue(currentRow.getCell(1)));
					account.setAddress(getCellValue(currentRow.getCell(2)));

					// Date of Birth - careful with date formats
					Cell dateCell = currentRow.getCell(3);
					if (dateCell != null && dateCell.getCellType() == CellType.NUMERIC
							&& DateUtil.isCellDateFormatted(dateCell)) {
						account.setDateOfBirth(dateCell.getLocalDateTimeCellValue().toLocalDate());
					} else {
						// Handle cases where date is not in correct format or is text
						// You might log a warning or set a default/null
						System.err.println("Warning: Invalid date format for row " + currentRow.getRowNum()
								+ ". Cell value: " + getCellValue(dateCell));
						// account.setDateOfBirth(null); // Or some default
					}

					account.setGender(getCellValue(currentRow.getCell(4)));
					account.setPassword(getCellValue(currentRow.getCell(5)));
					account.setPhoneNumber(getCellValue(currentRow.getCell(6)));
					account.setIdentityCard(getCellValue(currentRow.getCell(7)));
					account.setEmail(getCellValue(currentRow.getCell(8)));

					String roleIdStr = getCellValue(currentRow.getCell(9));
					int regisRole = Integer.parseInt(roleIdStr); // Assuming RoleID is a number

					account.setStatus(1);
					account.setRegisterDate(LocalDate.now());
					account.setDeleteFlag(0);
					account.setOne_time_password(00000); // Consider generating this dynamically or making it nullable
					account.setSeller_approve_flag(0); // Default

					if (regisRole == 2 && roleNVCang != null) {
						account.setRoles(roleNVCang);
					} else if (regisRole == 3 && roleNVKD != null) {
						account.setRoles(roleNVKD);
						account.setSeller_approve_flag(1); // Set for NVKD
					} else {
						System.err.println("Warning: Invalid or unhandled role ID for row " + currentRow.getRowNum()
								+ ". Role ID: " + regisRole);
						// Handle unhandled roles: e.g., skip, assign default, or throw error
						continue; // Skip this row if role is invalid
					}

					// Add to a list to be saved in a batch or one by one
					accountsToAdd.add(account);
					successCount++;

				} catch (Exception e) {
					errorCount++;
					System.err.println("Lỗi đọc dữ liệu từ hàng " + currentRow.getRowNum() + ": " + e.getMessage());
					// Log the error, perhaps add to a list of failed rows for feedback
				}
			}

			// Save all successfully parsed accounts
			for (Account acc : accountsToAdd) {
				accountService.addOrEditAccount(acc); // Assuming this handles both add/edit based on ID
			}

			model.addAttribute("messageSuccess",
					"Đã thêm " + successCount + " tài khoản thành công. Có " + errorCount + " tài khoản lỗi.");

		} catch (IOException e) {
			model.addAttribute("errorMessage", "Lỗi xử lý file Excel: " + e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			model.addAttribute("errorMessage", "Lỗi định dạng số trong file Excel: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Đã xảy ra lỗi không mong muốn khi xử lý file: " + e.getMessage());
			e.printStackTrace();
		}

		// Always return to the list page with updated data
		List<Account> listAccount = accountService.getListAccount();
		model.addAttribute("listAccount", listAccount);
		return "danhSachUser";
	}

	// Helper method to get cell value as String
	private String getCellValue(Cell cell) {
		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue().trim();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				// For dates, return as string if needed, or handle separately
				return cell.getLocalDateTimeCellValue().toLocalDate().toString();
			}
			return String.valueOf((long) cell.getNumericCellValue()); // For integers/longs
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula(); // Or evaluate the formula
		default:
			return "";
		}
	}

	// Helper method to check if a row is effectively empty
	private boolean isRowEmpty(Row row) {
		if (row == null) {
			return true;
		}
		for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
			Cell cell = row.getCell(cellNum);
			if (cell != null && cell.getCellType() != CellType.BLANK && !getCellValue(cell).isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@RequestMapping(value = { "/", "homePage" })
	public String homePage(Model model) {
		return "homePage";

	}

	/******/

	@GetMapping(value = "/forgotpassword")
	public String forgotpassword(Model model) {

		return "forgotpassword";

	}

	@RequestMapping(value = { "/deleteUser/{userName}" })
	public String thucHienDeleteUser(Model model, @PathVariable String userName) {
		accountService.deleteAccount(userName);
		model.addAttribute("delete", true);
		List<Account> listAccount = accountService.getListAccount();
		model.addAttribute("listAccount", listAccount);
		return "danhSachUser";
	}

	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/



	@RequestMapping(value = { "/thucHienUpdateProfile" })
	public String thucHienProfile(@ModelAttribute("formAccount") AccountDTO accountDTO, Account account, Model model) {

		account.setOne_time_password(45566);
		accountService.addOrEditAccount(account);
		model.addAttribute("update", true);
		List<Account> listAccount = accountService.getListAccount();
		model.addAttribute("listAccount", listAccount);
		return "danhSachUser";

	}

	@RequestMapping(value = { "/updateUser/{userName}" })
	public String updateUser(Model model, HttpSession httpSession, @PathVariable String userName) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}

		Map<Integer, String> ListRoleID = new HashMap<Integer, String>();
		List<Roles> listRoles = rolesService.getListRoles();
		for (Roles roles : listRoles) {
			ListRoleID.put(roles.getRoleID(), roles.getRoleName());
		}

		Account account1 = accountService.getAccountById(userName);
		model.addAttribute("listRoleID", ListRoleID);

		model.addAttribute("account", account1);
		return "updateProfile";

	}



	@RequestMapping(value = { "/listUser" })
	public String showUser(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Account> listAccount = accountService.getListAccount();
		model.addAttribute("listAccount", listAccount);
		return "danhSachUser";
	}

	@RequestMapping(value = { "/themMoiUser" })
	public String themUser(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		return "themMoiUser";
	}

	@PostMapping("/themUser")
	public String postAddAdmin(@ModelAttribute("formUser") AccountDTO accountDTO, Account account, Model model) {
		account.setAccountID(accountDTO.getUserName());
		account.setFullName(accountDTO.getFullName());
		account.setAddress(accountDTO.getAddress());
		account.setDateOfBirth(LocalDate.parse(accountDTO.getDateOfBirth()));
		account.setGender(accountDTO.getGender());
		account.setPassword(accountDTO.getPassword());
		account.setUserName(accountDTO.getUserName());
		account.setPhoneNumber(accountDTO.getPhoneNumber());
		account.setStatus(1);
		account.setIdentityCard(accountDTO.getIdentityCard());
		account.setEmail(accountDTO.getEmail());
		account.setRegisterDate(LocalDate.now());
		account.setDeleteFlag(0);
		account.setOne_time_password(00000);
		account.setSeller_approve_flag(0);
		regisRole = accountDTO.getRoleID();
		account.setSeller_approve_flag(0);
		if (regisRole == 2) {
			account.setRoles(roleNVCang);
		}
		if (regisRole == 3) {
			account.setRoles(roleNVKD);
			account.setSeller_approve_flag(1);
		}

		accountService.addOrEditAccount(account);
		model.addAttribute("messageAdmin", true);
		List<Account> listAccount = accountService.getListAccount();
		model.addAttribute("listAccount", listAccount);
		return "danhSachUser";

	}



	@RequestMapping(value = { "/updateProfile" })
	public String updateProfile(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");

		if (account == null) {
			return "redirect:/login";
		}
		Account account1 = accountService.getAccountById(account.getAccountID());
		model.addAttribute("account", account1);
		return "updateProfile";
	}

	@RequestMapping(value = { "/themAdmin" })
	public String themAdmin(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		return "themAdmin";
	}

}
