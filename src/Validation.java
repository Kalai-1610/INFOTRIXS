public class Validation {
    public Boolean emailCheck(String email){
        String sub =email.substring(email.length() - 10);

        if(sub.equals("@gmail.com")){
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean phoneNumberCheck(String PhoneNumber){
        if(PhoneNumber.length() == 10){
            return true;
        }
        else{
            return false;
        }
    }
}
