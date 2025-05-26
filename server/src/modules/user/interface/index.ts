import { UserAccount } from "../model";
import { UserLoginDto, UserLoginResponseDto } from "../model/dto";

export interface IUserRepository {
  login(data: UserLoginDto): Promise<UserLoginResponseDto>;
  getListUserByIds(ids: number[]): Promise<UserAccount[]>;
}

export interface IQueryHandler<Query, Result> {
  execute(query: Query): Promise<Result>;
}
