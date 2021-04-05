package hr.tvz.android.talhiCalculator.converters;

public class converterWeight {
    private String from_arg,to_arg;
    private  Double first_arg;

    private Integer first_arg_int;

    public converterWeight(String from_arg, String to_arg, Double first_arg) {
        this.from_arg = from_arg;
        this.to_arg = to_arg;
        this.first_arg = first_arg;
    }

    public converterWeight(String from_arg, String to_arg, Integer first_arg_int) {
        this.from_arg = from_arg;
        this.to_arg = to_arg;
        this.first_arg_int = first_arg_int;
    }


    public Double convert(){

        //Declaring variables
        Double result=0.0;
        Double first_arg_gm = 0.0;

        //switch statement to convert first argument to millimeters
        switch (from_arg){
            case "Gram":
            case "Gramo":
            case "Gramme":
            case "غرام":

                first_arg_gm = first_arg*1;
                break;
            case "Kilogram":
            case "Kilogramo":
            case "Kilogramme":
            case "كيلوغرام":

                first_arg_gm = first_arg*1000;
                break;
            case "Pound":
            case "Garlito":
            case "جنيه":

                first_arg_gm = first_arg*453.592;
                break;
            case "Ounce":
            case "Onza":
            case "أوقية":
                first_arg_gm = first_arg*28.35;
                break;
            case "Carat":
            case "Karat":
            case "Kilat":
            case "قيراط":


                first_arg_gm = first_arg*0.2;
                break;

        }


        switch (to_arg){

            case "Gram":
            case "Gramo":
            case "Gramme":
            case "غرام":

                result = first_arg_gm;
                break;
            case "Kilogram":
            case "Kilogramo":
            case "Kilogramme":
            case "كيلوغرام":

                result = first_arg_gm/1000;
                break;
            case "Pound":
            case "Garlito":
            case "جنيه":

                result = first_arg_gm/453.592;
                break;
            case "Ounce":
            case "Onza":
            case "أوقية":

                result = first_arg_gm/28.35;
                break;
            case "Carat":
            case "Karat":
            case "Kilat":
            case "قيراط":


                result = first_arg_gm/0.2;
                break;

        }

        return result;
    }
}
