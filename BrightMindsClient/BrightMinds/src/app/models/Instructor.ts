import { User } from './User';


export class Instructor {

    public id:number;
    public userId:User;
    public firstName:string;
    public lastName:string;
    public phoneNumber:string;
    public address:string;
    public DOB:number;
    public degree:string;
    public status:number;
    public createdAt:number;
    public updatedAt:number;

    constructor( id:number, userId:User, firstName:string, lastName:string, phoneNumber:string,
        address:string, DOB:number, degree:string, status:number, createdAt:number, UpdatedAt:number){
            this.id = id;
            this.userId = userId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.DOB = DOB;
            this.degree = degree;
            this.status = status;
            this.createdAt = createdAt;
            this.updatedAt = UpdatedAt;
    }

    //Write Getters and Setters later
    
}