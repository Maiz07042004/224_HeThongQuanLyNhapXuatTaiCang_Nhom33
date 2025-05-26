import { IQueryHandler, IUserRepository } from "../interface";
import { UserLoginDto, UserLoginResponseDto } from "../model/dto";

export class Login
  implements IQueryHandler<UserLoginDto, UserLoginResponseDto>
{
  constructor(private readonly repo: IUserRepository) {}
  async execute(query: UserLoginDto): Promise<UserLoginResponseDto> {
    try {
      const result = await this.repo.login(query);
      return result;
    } catch (error) {
      throw error;
    }
  }
}
