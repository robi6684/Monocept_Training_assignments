class ContactDetails{
    constructor(contactDetailsId,type){
        this.contactDetailsId = contactDetailsId;
        this.type = type;
    }

    static newDetails(contactDetailsId,type){
        return new ContactDetails(contactDetailsId,type);
    }

    updateContactDetailsId(newValue){
        if(!Number.isInteger(newValue))
        throw new Error("Please enter valid contact details ID");

        this.contactDetailsId = newValue;

    }

    updateType(newValue){
        if(typeof newValue != "string")
        throw new Error("Please enter valid type");

        this.type = newValue;
    }
}

module.exports = ContactDetails