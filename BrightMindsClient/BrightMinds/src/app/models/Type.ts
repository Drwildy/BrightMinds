
export class Type {

    private id:number
    private type:string;
    private status:number;
    private createdAt:number;
    private updatedAt:number;

    constructor(id:number, type:string, status:number, createdAt:number, updatedAt:number){
        this.id = id;
        this.type = type;
        this.status = status;
        this.createdAt = status;
        this.updatedAt = status;
    }

    public getId():number{
        return this.id;
    }
    
    public setId(id:number){
        this.id = id;
    }

    public getType():string{
        return this.type;
    }

    public setType(type:string){
        this.type = type;
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