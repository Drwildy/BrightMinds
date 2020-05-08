import { Type } from './Type';

export class User{
    
    public id:number;
    public typeid:Type;
    public username:string;
    public password:string;
    public status:number;
    public createdAt:number;
    public updatedAt:number;

    constructor(id:number, typeid:Type, username:string, password:string,
        status:number, createdAt:number, updatedAt:number){
            this.id = id;
            this.typeid = typeid;
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

    public getTypeId():Type{
        return this.typeid;
    }

    public setTypeId(typeId:Type){
        this.typeid = typeId;
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