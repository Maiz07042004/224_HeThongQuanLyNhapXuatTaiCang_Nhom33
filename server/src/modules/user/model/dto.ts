import { z } from "zod";

export const UserLoginSchema = z.object({
  Email: z.string(),
  MatKhau: z.string(),
});
export type UserLoginDto = z.infer<typeof UserLoginSchema>;
