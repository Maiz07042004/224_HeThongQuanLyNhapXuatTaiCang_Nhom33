import { Request, Response } from "express";
import { IQueryHandler, IUserRepository } from "../../interface";
import { UserLoginDto, UserLoginResponseDto } from "../../model/dto";

export class UserHttpService {
  constructor(
    private readonly login: IQueryHandler<UserLoginDto, UserLoginResponseDto>,
    private readonly repo: IUserRepository
  ) {}
  async loginUserAPI(req: Request, res: Response) {
    const { email, password } = req.body;
    try {
      const result = await this.login.execute({
        Email: email,
        MatKhau: password,
      });
      res.status(200).json(result);
    } catch (error) {
      res.status(500).json({ error: (error as Error).message });
    }
  }
  async getListUserByIdsAPI(req: Request, res: Response) {
    const ids = req.query.ids as string;
    try {
      const result = await this.repo.getListUserByIds(
        ids.split(",").map((id) => parseInt(id))
      );
      res.status(200).json({ data: result });
    } catch (error) {
      res.status(500).json({ error: (error as Error).message });
    }
  }
}
