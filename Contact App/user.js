const Contact = require("./contact")
const ContactDetails = require("./contactDetails")

class User{
    static allUser = [];
    constructor(userId,firstName,lastName,isAdmin,isActive){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
        this.contacts = [];
    }

    static checkUserAlreadyExists(userId){
        for (let index = 0; index < User.allUser.length; index++) {
            if(User.allUser[index].userId == userId)
            return [true,index];
        }
        return [false,-1];
    }


    static newAdmin(userId,firstName,lastName)
    {
        if(!Number.isInteger(userId))
        throw new Error("Please enter valid User ID");

        if(typeof firstName != "string")
        throw new Error("Please enter valid First Name");

        if(typeof lastName != "string")
        throw new Error("Please enter valid Last Name");

        let [isUserExist,indexOfUserFound] = User.checkUserAlreadyExists(userId);

        if(isUserExist)
        throw new Error("User Already Exists");

        const admin = new User(userId,firstName,lastName,true,true);
        User.allUser.push(admin);
        return admin;

    }

    newUser(userId,firstName,lastName){
        if(!this.isAdmin)
        throw new Error("Unauthorized Access");

        if(!Number.isInteger(userId))
        throw new Error("Please enter valid User ID");

        if(typeof firstName != "string")
        throw new Error("Please enter valid First Name");

        if(typeof lastName != "string")
        throw new Error("Please enter valid Last Name");

        let [isUserExist,indexOfUserFound] = User.checkUserAlreadyExists(userId);

        if(isUserExist)
        throw new Error("User Already Exists");

        const user = new User(userId,firstName,lastName,false,true);
        User.allUser.push(user);
        return user;

    }

    getUserDetails(userId){
        if(!this.isAdmin)
        throw new Error("Unauthorized Access");

        if(!Number.isInteger(userId))
        throw new Error("Please enter valid User ID");

        let [isUserExist,indexOfUserFound] = User.checkUserAlreadyExists(userId);

        if(!isUserExist)
        throw new Error("User does not exists");

        if(User.allUser[indexOfUserFound].isAdmin)
        throw new Error("Unauthorized access");

        return User.allUser[indexOfUserFound];

    }

    getAllUserDetails(){
        if(!this.isAdmin)
        throw new Error("Unauthorized Access");

        const userDetails = [];

        for (let index = 0; index < User.allUser.length; index++) {
            if(!User.allUser[index].isAdmin)
            userDetails.push(User.allUser[index]);
        }
        return userDetails;
    }

    updateUserDetail(userId,parameter,newValue){
        if(!this.isAdmin)
        throw new Error("Unauthorized Access");

        if(!Number.isInteger(userId))
        throw new Error("Please enter valid User ID");

        let [isUserExist,indexOfUserFound] = User.checkUserAlreadyExists(userId);

        if(!isUserExist)
        throw new Error("User does not exists");

        if(User.allUser[indexOfUserFound].isAdmin)
        throw new Error("Unauthorized access");


        switch (parameter) {
            case "userId": User.allUser[indexOfUserFound].updateUserId(newValue)
                break;
            case "firstName": User.allUser[indexOfUserFound].updateFirstName(newValue)
                break;
            case "lastName": User.allUser[indexOfUserFound].updateLastName(newValue)
            break;
            default:
                throw new Error("Invalid Parameter")

        }

    }

    updateUserId(newValue){
        if(!Number.isInteger(newValue))
        throw new Error("Please enter valid User ID");

        this.userId = newValue;
    }

    updateFirstName(newValue){
        if(typeof newValue != "string")
        throw new Error("Please enter valid First Name");

        
        this.firstName = newValue;
    }

    updateLastName(newValue){
        if(typeof newValue != "string")
        throw new Error("Please enter valid Last Name");

        this.lastName = newValue;
    }

    deleteUser(userId){
        if(!this.isAdmin)
        throw new Error("Unauthorized Access");

        if(!Number.isInteger(userId))
        throw new Error("Please enter valid User ID");

        let [isUserExist,indexOfUserFound] = User.checkUserAlreadyExists(userId);

        if(!isUserExist)
        throw new Error("User does not exists");

        User.allUser[indexOfUserFound].isActive = false;
    }

    checkContactAlreadyExists(contactId){
        for (let index = 0; index < this.contacts.length; index++) {
            if(this.contacts[index].contactId == contactId)
            return [true,index];
        }
        return [false,-1];
    }
    newContact(contactId,firstName,lastName){
        if(this.isAdmin)
        throw new Error("Unauthorized Access");

        if(!this.isActive)
        throw new Error("Unautorized Access");

        if(!Number.isInteger(contactId))
        throw new Error("Please enter valid Contact ID");

        if(typeof firstName != "string")
        throw new Error("Please enter valid First Name");

        if(typeof lastName != "string")
        throw new Error("Please enter valid Last Name");

        let [isContactExist, indexOfContact] = this.checkContactAlreadyExists(contactId);
        if (isContactExist) {
            throw new Error("Contact Already Exist");
        }
        const contact = Contact.newContact(contactId,firstName,lastName);
        this.contacts.push(contact);

        return contact;
    }

    getAllContacts(){
        if(this.isAdmin)
        throw new Error("Unauthorized Access");

        if(!this.isActive)
        throw new Error("Unautorized Access");

        return this.contacts;
    }

    updateContact(contactId,parameter,newValue){
        if(this.isAdmin)
        throw new Error("Unauthorized Access");

        if(!this.isActive)
        throw new Error("Unautorized Access");

        if(!Number.isInteger(contactId))
        throw new Error("Please enter valid Contact ID");

        let [isContactExist, indexOfContact] = this.checkContactAlreadyExists(contactId);
        if (!isContactExist) {
            throw new Error("Contact does not exists");
        }

        switch(parameter){
            case "contactId":this.contacts[indexOfContact].updateContactId(newValue)
                break;
            case "firstName":this.contacts[indexOfContact].updateContactFirstName(newValue)
                break;
            case "lastName":this.contacts[indexOfContact].updateContactLastName(newValue)
                break;
            default:
                throw new Error("Invalid Parameter");
        }

    }

   

    deleteContact(contactId){
        if(this.isAdmin)
        throw new Error("Unauthorized Access");

        if(!this.isActive)
        throw new Error("Unautorized Access");

        if(!Number.isInteger(contactId))
        throw new Error("Please enter valid Contact ID");

        let [isContactExist, indexOfContact] = this.checkContactAlreadyExists(contactId);
        if (!isContactExist) {
            throw new Error("Contact does not exists");
        }

        this.contacts[indexOfContact].isActive = false;

    }

    checkContactDetailsAlreadyExists(contactDetailsId,contactId){
        let[isContactExist,indexOfContact] = this.checkContactAlreadyExists(contactId);
        if(!isContactExist)
        throw new Error("Contact does not exists");

        for(let index=0; index<this.contacts[indexOfContact].contactDetails.length; index++){
        if(this.contacts[indexOfContact].contactDetails[index].contactDetailsId
            == contactDetailsId)
            return [true,indexOfContact,index];
        }
        
        return [false,indexOfContact,-1];
    }

    newContactDetails(contactId,contactDetailsId,type){
        if(this.isAdmin)
        throw new Error("Unauthorized Access");

        if(!this.isActive)
        throw new Error("Unautorized Access");

        if(!Number.isInteger(contactId))
        throw new Error("Please enter valid contact ID");

        if(!Number.isInteger(contactDetailsId))
        throw new Error("Please enter valid contact details ID");

        if(typeof type != "string")
        throw new Error("Please enter valid type");

        let [isContactDetailsExist,indexOfContact,indexOfContactDetails] = this.checkContactDetailsAlreadyExists(contactDetailsId,contactId);

        if(!this.contacts[indexOfContact].isActive)
        throw new Error("Contact does not exists");
        if(isContactDetailsExist)
        throw new Error("Contact Details already exists");

        const contactDetails = ContactDetails.newDetails(contactDetailsId,type);
        this.contacts[indexOfContact].contactDetails.push(contactDetails);
        return contactDetails;

    }

    getAllContactdetails(contactId){
        if(this.isAdmin)
        throw new Error("Unauthorized Access");

        if(!this.isActive)
        throw new Error("Unautorized Access");

        if(!Number.isInteger(contactId))
        throw new Error("Please enter valid contact ID");

        let [isContactExist, indexOfContact] = this.checkContactAlreadyExists(contactId);

        if(!isContactExist)
        throw new Error("Contact does not exists");

        return this.contacts[indexOfContact].contactDetails;
    }

    deleteContactDetails(contactId,contactDetailsId){
        if(this.isAdmin)
        throw new Error("Unauthorized Access");

        if(!this.isActive)
        throw new Error("Unautorized Access");

        if(!Number.isInteger(contactId))
        throw new Error("Please enter valid contact ID");

        if(!Number.isInteger(contactDetailsId))
        throw new Error("Please enter valid contact details ID");
        
        let [isContactDetailsExist,indexOfContact,indexOfContactDetails] = this.checkContactDetailsAlreadyExists(contactDetailsId,contactId);

        if(!this.contacts[indexOfContact].isActive)
        throw new Error("Contact does not exists");

        if(!isContactDetailsExist)
        throw new Error("Contact Details does not exists");

        this.contacts[indexOfContact].contactDetails.splice(indexOfContactDetails,indexOfContactDetails+1);

    }

    updateContactDetails(contactId,contactDetailsId,parameter,newValue){
        if(this.isAdmin)
        throw new Error("Unauthorized Access");

        if(!this.isActive)
        throw new Error("Unautorized Access");

        if(!Number.isInteger(contactId))
        throw new Error("Please enter valid contact ID");

        if(!Number.isInteger(contactDetailsId))
        throw new Error("Please enter valid contact details ID");
        
        let [isContactDetailsExist,indexOfContact,indexOfContactDetails] = this.checkContactDetailsAlreadyExists(contactDetailsId,contactId);

        if(!this.contacts[indexOfContact].isActive)
        throw new Error("Contact does not exists");

        if(!isContactDetailsExist)
        throw new Error("Contact Details does not exists");
        

        switch(parameter){
            case "contactDetailsId":
                this.contacts[indexOfContact].contactDetails[indexOfContactDetails].updateContactDetailsId(newValue);
                break;
            case "type":
                this.contacts[indexOfContact].contactDetails[indexOfContactDetails].updateType(newValue);
                break;
            default:
                throw new Error("Invalid Parameter");
        }
        

    }




}

module.exports = User