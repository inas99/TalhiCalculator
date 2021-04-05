package hr.tvz.android.talhiCalculator.converters;

public class converterVolume {

    private String from_arg,to_arg;
    private  Double first_arg;

    private Integer first_arg_int;

    public converterVolume(String from_arg, String to_arg, Double first_arg) {
        this.from_arg = from_arg;
        this.to_arg = to_arg;
        this.first_arg = first_arg;
    }

    public converterVolume(String from_arg, String to_arg, Integer first_arg_int) {
        this.from_arg = from_arg;
        this.to_arg = to_arg;
        this.first_arg_int = first_arg_int;
    }


    public Double convert(){

        //Declaring variables
        Double result=0.0;
        Double first_arg_ml = 0.0;

        //switch statement to convert first argument to millimeters
        switch (from_arg){
            case "Milliliter":
            case "Mililitere":
            case "Milímetro":
            case "Millimètre":
            case "مليمتر":


                first_arg_ml = first_arg*1;
                break;
            case "Liter":
            case "Litere":
            case "Litro":
            case "Litre":
            case "لتر":


                first_arg_ml = first_arg*1000;
                break;
            case "US Fluid ounce":
            case "ABD Sıvı onsu":
            case "US Onza líquida":
            case "Once liquide américaine":
            case "أونصة سائلة أمريكية":


                first_arg_ml = first_arg*29.574;
                break;
            case "US Quart":
            case "ABD Quart":
            case "US Cuarto de galón":
            case "Quart américain":
            case "أمريكية كوارت":


                first_arg_ml = first_arg*946.353;
                break;
            case "US Gallon":
            case "ABD Gallon":
            case "US Galón":
            case "Gallon américain":
            case "أمريكية جالون":


                first_arg_ml = first_arg*3785.412;
                break;

        }


        switch (to_arg){

            case "Milliliter":
            case "Millilitere":
            case "Milímetro":
            case "Millimètre":
            case "مليمتر":


                result = first_arg_ml;
                break;
            case "Liter":
            case "Litere":
            case "Litro":
            case "Litre":
            case "لتر":


                result = first_arg_ml/1000;
                break;
            case "US Fluid ounce":
            case "ABD Sıvı onsu":
            case "US Onza líquida":
            case "Once liquide américaine":
            case "أونصة سائلة أمريكية":


                result = first_arg_ml/29.574;
                break;
            case "US Quart":
            case "ABD Quart":
            case "US Cuarto de galón":
            case "Quart américain":
            case "أمريكية كوارت":


                result = first_arg_ml/946.353;
                break;
            case "US Gallon":
            case "ABD Gallon":
            case "US Galón":
            case "Gallon américain":
            case "أمريكية جالون":


                result = first_arg_ml/3785.412;
                break;

        }

        return result;
    }
}
