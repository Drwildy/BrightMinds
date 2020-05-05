import { User } from './User';


export class Admin {

    public id:number;
    public userId:User;
    public firstName:string;
    public lastName:string;
    public status:number;
    public createdAt:number;
    public updatedAt:number;

    constructor( id:number, userId:User, firstName:string, lastName:string, status:number, createdAt:number, UpdatedAt:number){
            this.id = id;
            this.userId = userId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.status = status;
            this.createdAt = createdAt;
            this.updatedAt = UpdatedAt;
    }

    //Write Getters and Setters later
    
}