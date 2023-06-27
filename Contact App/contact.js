class Contact{
    constructor(contactId,firstName,lastName,isActive){
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive; 
        this.contactDetails = [];
    }

    static newContact(contactId,firstName,lastName){
        return new Contact(contactId,firstName,lastName,true);
    }
    updateContactId(newValue){
        if(!Number.isInteger(newValue))
        throw new Error("Please enter valid Contact ID");

        this.contactId = newValue;
    }
    updateContactFirstName(newValue){
        if(typeof newValue != "string")
        throw new Error("Please enter valid First Name");

        this.firstName = newValue;
    }

    updateContactLastName(newValue){
        if(typeof newValue != "string")
        throw new Error("Please enter valid Last Name");

        this.lastName = newValue;
    }
 
}


module.exports = Contact