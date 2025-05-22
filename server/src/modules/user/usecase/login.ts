import { IQueryHandler, IUserRepository } from "../interface";
import { UserLoginDto } from "../model/dto";

export class Login implements IQueryHandler<UserLoginDto, string> {
  constructor(private readonly repo: IUserRepository) {}
  async execute(query: UserLoginDto): Promise<string> {
    try {
      const result = await this.repo.login(query);
      return result;
    } catch (error) {
      throw error;
    }
  }
}
