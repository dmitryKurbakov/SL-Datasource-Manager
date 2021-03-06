package dataobject;

public class DsParams {

    private String param_name;
    private String param_type;
    private String param_dvalue;
    private Boolean param_var;

    public String getParam_name() {
        return param_name;
    }

    public String getParam_type() {
        return param_type;
    }

    public String getParam_dvalue() {
        return param_dvalue;
    }

    public Boolean getParam_var() {
        return param_var;
    }

    public DsParams(String param_name, String param_dvalue, String param_type, Boolean param_var) {
        this.param_name = param_name;
        this.param_dvalue = param_dvalue;
        this.param_type = param_type;
        this.param_var = param_var;
    }

    @Override
    public String toString() {
        return param_name + "=" + param_dvalue;
    }
}
