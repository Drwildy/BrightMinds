
export class Student {

    private id:number;
    private userId:number;
    private firstName:string;
    private lastName:string;
    private phoneNumber:string;
    private address:string;
    private DOB:Date;
    private status:number;
    private createdAt:Date;
    private updatedAt:Date;

    constructor( id:number, userId:number, firstName:string, lastName:string, phoneNumber:string,
        address:string, DOB:Date, status:number, createdAt:Date, UpdatedAt:Date){
            this.id = id;
            this.userId = userId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.DOB = DOB;
            this.status = status;
            this.createdAt = createdAt;
            this.updatedAt = UpdatedAt;
    }


    public getId():number{
        return this.id;
    }
    
    public setId(id:number){
        this.id = id;
    }

    public getUserId():number{
        return this.userId;
    }

    public setUserId(userId:number){
        this.userId = userId;
    }

    public getFirstName():string{
        return this.firstName;
    }

    public setFirstName(firstName:string){
        this.firstName=firstName;
    }

    public getLastName():string{
        return this.lastName;
    }

    public setLastName(lastName:string){
        this.lastName = lastName;
    }

    public getPhoneNumber():string{
        return this.phoneNumber;
    }

    public setPhoneNumber(phoneNumber:string){
        this.phoneNumber = phoneNumber
    }

    public getAddress():string{
        return this.address;
    }

    public setAddress(address:string){
        this.address = address;
    }

    public getDOB():Date{
        return this.DOB;
    }

    public setDOB(DOB:Date){
        this.DOB = DOB;
    }

    public getStatus():number{
        return this.status;
    }

    public setStatus(status:number){
        this.status = status;
    }

    public getCreatedAt():Date{
        return this.createdAt;
    }

    public setCreatedAt(createdAt:Date){
        this.createdAt = createdAt;
    }

    public getUpdatedAt():Date{
        return this.updatedAt;
    }

    public setUpdatedAt(updatedAt:Date){
        this.updatedAt = updatedAt;
    }
}