package hr.tvz.android.talhiCalculator.converters;

public class converterArea {
    private String from_arg,to_arg;
    private  Double first_arg;

    private Integer first_arg_int;

    public converterArea(String from_arg, String to_arg, Double first_arg) {
        this.from_arg = from_arg;
        this.to_arg = to_arg;
        this.first_arg = first_arg;
    }

    public converterArea(String from_arg, String to_arg, Integer first_arg_int) {
        this.from_arg = from_arg;
        this.to_arg = to_arg;
        this.first_arg_int = first_arg_int;
    }


    public Double convert(){

        //Declaring variables
        Double result=0.0;
        Double first_arg_m = 0.0;

        //switch statement to convert first argument to millimeters
        switch (from_arg){
            case "Sq. Millimeter":
            case "Sq. Milimetere":
            case "Sq. Milímetro":
            case "Sq. Millimètre":
            case "سكوير. مليمتر":

                first_arg_m = first_arg*0.000001;
                break;
            case "Sq. Centimeter":
            case "Sq. Santimetere":
            case "Sq. Centímetro":
            case "Sq. Centimètre":
            case "سكوير. سنتيمتر":

                first_arg_m = first_arg*0.0001;
                break;
            case "Sq. Meter":
            case "Sq. Metere":
            case "Sq. Metro":
            case "Sq. Mètre":
            case "سكوير. متر":

                first_arg_m = first_arg*1;
                break;
            case "Sq. Kilometer":
            case "Sq. Kilometere":
            case "Sq. Kilómetro":
            case "Sq. Kilomètre":
            case "سكوير. كيلومتر":

                first_arg_m = first_arg*1000000;
                break;
            case "Sq. Mile":
            case "Sq. Mil":
            case "Sq. Milla":
            case "سكوير. ميل":

                first_arg_m = first_arg*2589988.11;
                break;

        }



        switch (to_arg){
            case "Sq. Millimeter":
            case "Sq. Milimetere":
            case "Sq. Milímetro":
            case "Sq. Millimètre":
            case "سكوير. مليمتر":

                result = first_arg_m*1000000;
                break;
            case "Sq. Centimeter":
            case "Sq. Snatimetere":
            case "Sq. Centímetro":
            case "Sq. Centimètre":
            case "سكوير. سنتيمتر":

                result = first_arg_m*10000;
                break;
            case "Sq. Meter":
            case "Sq. Metere":
            case "Sq. Metro":
            case "Sq. Mètre":
            case "سكوير. متر":

                result = first_arg_m/1;
                break;
            case "Sq. Kilometer":
            case "Sq. Kilometere":
            case "Sq. Kilómetro":
            case "Sq. Kilomètre":
            case "سكوير. كيلومتر":

                result = first_arg_m/1000000;
                break;
            case "Sq. Mile":
            case "Sq. Mil":
            case "Sq. Milla":
            case "سكوير. ميل":

                result = first_arg_m/2589988.11;
                break;

        }


        return result;
    }
}
