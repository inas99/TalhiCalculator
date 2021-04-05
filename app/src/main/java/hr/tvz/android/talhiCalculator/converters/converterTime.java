package hr.tvz.android.talhiCalculator.converters;

public class converterTime {
    private String from_arg,to_arg;
    private  Double first_arg;

    private Integer first_arg_int;

    public converterTime(String from_arg, String to_arg, Double first_arg) {
        this.from_arg = from_arg;
        this.to_arg = to_arg;
        this.first_arg = first_arg;
    }

    public converterTime(String from_arg, String to_arg, Integer first_arg_int) {
        this.from_arg = from_arg;
        this.to_arg = to_arg;
        this.first_arg_int = first_arg_int;
    }


    public Double convert(){

        //Declaring variables
        Double result=0.0;
        Double first_arg_sec = 0.0;

        //switch statement to convert first argument to millimeters
        switch (from_arg){
            case "Millisecond":
            case "Milisaniye":
            case "Milisegundo":
            case "Milliseconde":
            case "ميلي ثانية":


                first_arg_sec = first_arg*0.001;
                break;
            case "Second":
            case "Saniye":
            case "segundo":
            case "Seconde":
            case "ثانية":


                first_arg_sec = first_arg*1;
                break;
            case "Minute":
            case "Dakika":
            case "Minuto":
            case "دقيقة":


                first_arg_sec = first_arg*60;
                break;
            case "Hour":
            case "Saat":
            case "Hora":
            case "Heur":
            case "ساعة":


                first_arg_sec = first_arg*3600;
                break;
            case "Day":
            case "Gün":
            case "Día":
            case "Jour":
            case "يوم":


                first_arg_sec = first_arg*86400;
                break;

        }


        switch (to_arg){

            case "Millisecond":
            case "Milisaniye":
            case "Milisegundo":
            case "Milliseconde":
            case "ميلي ثانية":


                result = first_arg_sec/0.001;
                break;
            case "Second":
            case "Saniye":
            case "segundo":
            case "Seconde":
            case "ثانية":


                result = first_arg_sec/1;
                break;
            case "Minute":
            case "Dakika":
            case "Minuto":
            case "دقيقة":


                result = first_arg_sec/60;
                break;
            case "Hour":
            case "Saat":
            case "Hora":
            case "Heur":
            case "ساعة":


                result = first_arg_sec/3600;
                break;
            case "Day":
            case "Gün":
            case "Día":
            case "Jour":
            case "يوم":


                result = first_arg_sec/86400;
                break;

        }

        return result;
    }
}
