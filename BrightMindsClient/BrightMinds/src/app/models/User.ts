export class User{
    
    private id:number;
    private typeId:number;
    private username:string;
    private password:string;
    private status:number;
    private createdAt:number;
    private updatedAt:number;

    constructor(id:number, typeId:number, username:string, password:string,
        status:number, createdAt:number, updatedAt:number){
            this.id = id;
            this.typeId = typeId;
            this.username = username;
            this.password = password;
            this.status = status;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

    public getId():number{
        return this.id;
    }
    
    public setId(id:number){
        this.id = id;
    }

    public getTypeId():number{
        return this.typeId;
    }

    public setTypeId(typeId:number){
        this.typeId = typeId;
    }

    public getUsername():string{
        return this.username;
    }

    public setUsername(username:string){
        this.username = username;
    }

    public getPassword():string{
        return this.password;
    }

    public setPassword(password:string){
        this.password = password;
    }

    public getStatus():number{
        return this.status;
    }

    public setStatus(status:number){
        this.status = status;
    }

    public getCreatedAt():number{
        return this.createdAt;
    }

    public setCreatedAt(createdAt:number){
        this.createdAt = createdAt;
    }

    public getUpdatedAt():number{
        return this.updatedAt;
    }

    public setUpdatedAt(updatedAt:number){
        this.updatedAt = updatedAt;
    }

}