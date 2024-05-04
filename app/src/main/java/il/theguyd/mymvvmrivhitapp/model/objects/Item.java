package il.theguyd.mymvvmrivhitapp.model.objects;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Fts4;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Items")
public class Item {
    @PrimaryKey(autoGenerate = true)
        private int _id;

        @ColumnInfo(name=("id"))
        @SerializedName("item_id")
        @NonNull
        private String itemId;

        @ColumnInfo(name=("name"))
        @SerializedName("item_name")
        private String itemName;
        @ColumnInfo(name=("extended_description"))
        @SerializedName("item_extended_description")
        private String itemExtendedDescription;

    @ColumnInfo(name=("description"))
        @SerializedName("item_part_num")
        private String itemPartNum;
        @ColumnInfo(name=("barcode"))
        @SerializedName("barcode")
        private String barcode;

        @ColumnInfo(name=("group_id"))
        @SerializedName("item_group_id")
        private int itemGroupId;

        @ColumnInfo(name=("storage_id"))
        @SerializedName("storage_id")
        private int storageId;

        @ColumnInfo(name=("quantity"))
        @SerializedName("quantity")
        private double quantity;

        @ColumnInfo(name=("cost_nis"))
        @SerializedName("cost_nis")
        private float costNis;

        @ColumnInfo(name=("sale_nis"))
        @SerializedName("sale_nis")
        private float saleNis;

        @ColumnInfo(name=("currency_id"))
        @SerializedName("currency_id")
        private int currencyId;

        @ColumnInfo(name=("cost_mtc"))
        @SerializedName("cost_mtc")
        private float costMtc;

        @ColumnInfo(name=("sales_mtc"))
        @SerializedName("sales_mtc")
        private float sale_mtc;

        @ColumnInfo(name=("picture_link"))
        @SerializedName("picture_link")
        private String picture_link;

        @ColumnInfo(name=("exempt_vat"))
        @SerializedName("exempt_vat")
        private boolean exemptVat;

        @ColumnInfo(name=("avitem"))
        @SerializedName("avitem")
        private int avitem;

        @ColumnInfo(name=("location"))
        @SerializedName("location")
        private String location;

        @ColumnInfo(name=("is_serial"))
        @SerializedName("is_serial")
        private int is_serial;

        @ColumnInfo(name=("sapak"))
        @SerializedName("sapak")
        private int sapak;

        @ColumnInfo(name=("item_name_en"))
        @SerializedName("item_name_en")
        private String itemNameEn;


        public int get_id() {
            return _id;
        }

        public void set_id(int _id) {
            this._id = _id;
        }


        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemExtendedDescription() {
            return itemExtendedDescription;
        }

        public void setItemExtendedDescription(String itemExtendedDescription) {
            this.itemExtendedDescription = itemExtendedDescription;
        }

        public String getItemPartNum() {
            return itemPartNum;
        }

        public void setItemPartNum(String itemPartNum) {
            this.itemPartNum = itemPartNum;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public int getItemGroupId() {
            return itemGroupId;
        }

        public void setItemGroupId(int itemGroupId) {
            this.itemGroupId = itemGroupId;
        }

        public int getStorageId() {
            return storageId;
        }

        public void setStorageId(int storageId) {
            this.storageId = storageId;
        }

        public double getQuantity() {
            return quantity;
        }

        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }

        public float getCostNis() {
            return costNis;
        }

        public void setCostNis(float costNis) {
            this.costNis = costNis;
        }

        public float getSaleNis() {
            return saleNis;
        }

        public void setSaleNis(float saleNis) {
            this.saleNis = saleNis;
        }

        public int getCurrencyId() {
            return currencyId;
        }

        public void setCurrencyId(int currencyId) {
            this.currencyId = currencyId;
        }

        public float getCostMtc() {
            return costMtc;
        }

        public void setCostMtc(float costMtc) {
            this.costMtc = costMtc;
        }

        public float getSale_mtc() {
            return sale_mtc;
        }

        public void setSale_mtc(float sale_mtc) {
            this.sale_mtc = sale_mtc;
        }

        public String getPicture_link() {
            return picture_link;
        }

        public void setPicture_link(String picture_link) {
            this.picture_link = picture_link;
        }

        public boolean isExemptVat() {
            return exemptVat;
        }

        public void setExemptVat(boolean exemptVat) {
            this.exemptVat = exemptVat;
        }

        public int getAvitem() {
            return avitem;
        }

        public void setAvitem(int avitem) {
            this.avitem = avitem;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getIs_serial() {
            return is_serial;
        }

        public void setIs_serial(int is_serial) {
            this.is_serial = is_serial;
        }

        public int getSapak() {
            return sapak;
        }

        public void setSapak(int sapak) {
            this.sapak = sapak;
        }

        public String getItemNameEn() {
            return itemNameEn;
        }

        public void setItemNameEn(String itemNameEn) {
            this.itemNameEn = itemNameEn;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "itemId='" + itemId + '\'' +
                    ", itemName='" + itemName + '\'' +
                    ", itemExtendedDescription='" + itemExtendedDescription + '\'' +
                    ", itemPartNum='" + itemPartNum + '\'' +
                    ", barcode='" + barcode + '\'' +
                    ", itemGroupId=" + itemGroupId +
                    ", storageId=" + storageId +
                    ", quantity=" + quantity +
                    ", costNis=" + costNis +
                    ", saleNis=" + saleNis +
                    ", currencyId=" + currencyId +
                    ", costMtc=" + costMtc +
                    ", sale_mtc=" + sale_mtc +
                    ", picture_link='" + picture_link + '\'' +
                    ", exemptVat=" + exemptVat +
                    ", avitem=" + avitem +
                    ", location='" + location + '\'' +
                    ", is_serial=" + is_serial +
                    ", sapak=" + sapak +
                    ", itemNameEn='" + itemNameEn + '\'' +
                    '}';
        }
}

