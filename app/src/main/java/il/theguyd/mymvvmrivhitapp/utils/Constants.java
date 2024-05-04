package il.theguyd.mymvvmrivhitapp.utils;

/**
 * sensitive information was deleted - for now you cannot use this
 * **/


public class Constants {

    //////////////////////////////////// network /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final String RIVHIT_BASE_API_ADDR = "replace";

    public static final String RIVHIT_ONLIE_API =  "replace";

    public static final String RIVHIT_ONLINE_ADDR = "replace" + RIVHIT_BASE_API_ADDR + RIVHIT_ONLIE_API ;
    public static final String TOKEN =  "replace";

    /////////////////////////////// fragments tags //////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final String MAIN_INVENTORY_FRAGMENT_TAG = "InventoryFragment";

    ////////////////////////////// settings /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final String SPAN_COUNT = "span_count";
    public static final String INFO_ON_CARD = "info_on_card";

    public  enum ImageProportions{
        SQUARE (500 ,500),
        RECTANGLE (300,300);

    private int width,height;
        ImageProportions(int width, int height){
        this.width=width;
        this.height=height;
    }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }







}
