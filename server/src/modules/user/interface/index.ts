import { UserAccount } from "../model";
import { UserLoginDto } from "../model/dto";

export interface IUserRepository {
  login(data: UserLoginDto): Promise<string>;
  getListUserByIds(ids: number[]): Promise<UserAccount[]>;
}

export interface IQueryHandler<Query, Result> {
  execute(query: Query): Promise<Result>;
}
