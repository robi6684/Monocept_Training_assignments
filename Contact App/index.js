const User = require("./user")
try{
    const admin1 = User.newAdmin(101,"Ravi","Kumar");
    console.log("admin1>>>>>>", admin1);
    const user1 = admin1.newUser(102,"Abhishek","Kumar");
    console.log("user1>>>>>>", user1);
    const userDetails = admin1.getUserDetails(102);
    console.log("User Details>>>>>",userDetails);
    admin1.updateUserDetail(102,"firstName","Raman");
    const user2 = admin1.newUser(103,"Rakesh","Singh");
    admin1.deleteUser(103);
    const allUserDetails = admin1.getAllUserDetails();
    console.log("All Users>>>>>>",allUserDetails);
    const contact1 = user1.newContact(1001,"Akash","Kumar");
    const contact2 = user1.newContact(1002,"Animesh","Kumar");
    console.log("User1>>>>>",user1);
    user1.updateContact(1002,"firstName","Aman");
    
    user1.deleteContact(1002);
    const contacts = user1.getAllContacts();
    console.log("All Contacts>>>>>>",contacts);

    const contactDetails = user1.newContactDetails(1001,11,"Email");
    console.log(contactDetails);
    
    

    //user1.deleteContactDetails(1001,11);
    user1.updateContactDetails(1001,11,"type","Mobile");
    const allContactDetails = user1.getAllContactdetails(1001);
    console.log("All contact details>>>>",allContactDetails);
    
    

}
catch(error){
    console.log(error.message);
}