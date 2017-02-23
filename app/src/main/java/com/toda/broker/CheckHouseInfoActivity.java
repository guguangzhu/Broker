package com.toda.broker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.toda.broker.view.UnitDescriptionLayout;
import com.toda.broker.view.dialog.CommonInputDialog;
import com.toda.broker.view.dialog.CommonInputNumDialog;
import com.toda.broker.view.dialog.CommonSelectDialog;
import com.toda.broker.view.dialog.CommonTagDialog;
import com.toda.broker.view.dialog.FloorNumDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 验房户型资料
 * Created by guugangzhu on 2016/12/29.
 */

public class CheckHouseInfoActivity extends BaseActivity {

    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.ll_photo)
    LinearLayout llPhoto;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ll_address)
    LinearLayout llAddress;
    @BindView(R.id.tv_landmark)
    TextView tvLandmark;
    @BindView(R.id.ll_landmark)
    LinearLayout llLandmark;
    @BindView(R.id.tv_profile)
    TextView tvProfile;
    @BindView(R.id.ll_profile)
    LinearLayout llProfile;
    @BindView(R.id.tv_house_type)
    TextView tvHouseType;
    @BindView(R.id.ll_type)
    UnitDescriptionLayout llType;
    @BindView(R.id.tv_room_amount)
    TextView tvRoomAmount;
    @BindView(R.id.ll_bedroom)
    UnitDescriptionLayout llBedroom;
    @BindView(R.id.tv_hall)
    TextView tvHall;
    @BindView(R.id.ll_hall)
    UnitDescriptionLayout llHall;
    @BindView(R.id.tv_kitchen)
    TextView tvKitchen;
    @BindView(R.id.ll_kitchen)
    UnitDescriptionLayout llKitchen;
    @BindView(R.id.tv_toilet)
    TextView tvToilet;
    @BindView(R.id.ll_toilet)
    UnitDescriptionLayout llToilet;
    @BindView(R.id.tv_balcony)
    TextView tvBalcony;
    @BindView(R.id.ll_balcony)
    UnitDescriptionLayout llBalcony;
    @BindView(R.id.tv_garden)
    TextView tvGarden;
    @BindView(R.id.ll_garden)
    UnitDescriptionLayout llGarden;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.ll_area)
    UnitDescriptionLayout llArea;
    @BindView(R.id.tv_inner_area)
    TextView tvInnerArea;
    @BindView(R.id.ll_inner_area)
    UnitDescriptionLayout llInnerArea;
    @BindView(R.id.tv_floor)
    TextView tvFloor;
    @BindView(R.id.ll_floor)
    UnitDescriptionLayout llFloor;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.ll_price)
    UnitDescriptionLayout llPrice;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.ll_total_price)
    UnitDescriptionLayout llTotalPrice;
    @BindView(R.id.tv_standard)
    TextView tvStandard;
    @BindView(R.id.ll_standard)
    UnitDescriptionLayout llStandard;
    @BindView(R.id.tv_period)
    TextView tvPeriod;
    @BindView(R.id.ll_period)
    UnitDescriptionLayout llPeriod;
    @BindView(R.id.tv_has_elevator)
    TextView tvHasElevator;
    @BindView(R.id.ll_has_elevator)
    UnitDescriptionLayout llHasElevator;
    @BindView(R.id.tv_orientation)
    TextView tvOrientation;
    @BindView(R.id.ll_orientation)
    UnitDescriptionLayout llOrientation;

    public static final int REQUEST_CITY = 111;
    public static final int CHOOSE_PIC = 112;
    String cityName, cityId, provinceName, provinceId, regionId, regionName;  //省市区
    List<String> mFeatureList=new ArrayList<>();
    String floorNum, totalFloorNum;
    @BindView(R.id.tv_area_title)
    TextView tvAreaTitle;
    @BindView(R.id.tv_inner_area_title)
    TextView tvInnerAreaTitle;
    @BindView(R.id.tv_price_title)
    TextView tvPriceTitle;
    @BindView(R.id.tv_total_money_title)
    TextView tvTotalMoneyTitle;
    @BindView(R.id.tv_feature)
    TextView tvFeature;
    @BindView(R.id.ll_feature)
    UnitDescriptionLayout llFeature;
    @BindView(R.id.tv_region)
    TextView tvRegion;
    @BindView(R.id.ll_region)
    LinearLayout llRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_house_info);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        setTitle("户型资料");
        setTopBarRightText("完成");
    }

    @Override
    public void onTopRightClick() {
        super.onTopRightClick();
        toast("完成");
    }


    @OnClick({R.id.ll_photo, R.id.ll_title,R.id.ll_region, R.id.ll_address, R.id.ll_landmark, R.id.ll_profile, R.id.ll_type, R.id.ll_bedroom, R.id.ll_hall, R.id.ll_kitchen, R.id.ll_balcony, R.id.ll_garden,
            R.id.ll_area, R.id.ll_inner_area, R.id.ll_floor, R.id.ll_price, R.id.ll_total_price, R.id.ll_standard, R.id.ll_period, R.id.ll_has_elevator, R.id.ll_orientation, R.id.ll_toilet, R.id.ll_feature})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_photo:
                showPicture();
                break;
            case R.id.ll_title:
                showTitle();
                break;
            case R.id.ll_region:
                goPage(CommonSelectCityActivity.class, null, REQUEST_CITY);
                break;
            case R.id.ll_address:
                showAddress();
                break;
            case R.id.ll_landmark:
                break;
            case R.id.ll_profile:
                showDescription();
                break;
            case R.id.ll_type:
                showType();
                break;
            case R.id.ll_bedroom:
                showRooms();
                break;
            case R.id.ll_hall:
                showHall();
                break;
            case R.id.ll_kitchen:
                showKichen();
                break;
            case R.id.ll_toilet:
                showWashroom();
                break;
            case R.id.ll_balcony:
                showBalcony();
                break;
            case R.id.ll_garden:
                showGarden();
                break;
            case R.id.ll_area:
                showAreaDialog();
                break;
            case R.id.ll_inner_area:
                showInnerAreaDialog();
                break;
            case R.id.ll_floor:
                showFloor();
                break;
            case R.id.ll_price:
                showAveragePriceDialog();
                break;
            case R.id.ll_total_price:
                showTotalPriceDialog();
                break;
            case R.id.ll_standard:
                showStandard();
                break;
            case R.id.ll_period:
                showYears();
                break;
            case R.id.ll_has_elevator:
                showElevator();
                break;
            case R.id.ll_orientation:
                showOrientation();
                break;
            case R.id.ll_feature:
                showFeature();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CITY:
                if (resultCode == RESULT_OK) {
//                    String city=data.getStringExtra(KEY_DATA);
//                    tvCity.setText(city);
                    this.cityId = data.getStringExtra(CommonSelectCityActivity.KEY_CITY_ID);
                    this.cityName = data.getStringExtra(CommonSelectCityActivity.KEY_CITY_NAME);
                    this.provinceId = data.getStringExtra(CommonSelectCityActivity.KEY_PROVINCE_ID);
                    this.provinceName = data.getStringExtra(CommonSelectCityActivity.KEY_PROVINCE_NAME);
                    regionId = data.getStringExtra(CommonSelectCityActivity.KEY_REGION_ID);
                    regionName = data.getStringExtra(CommonSelectCityActivity.KEY_REGION_NAME);
                    tvRegion.setText(provinceName + " " + cityName + " " + regionName);
                }
                break;
            case CHOOSE_PIC:
                if (resultCode == ImagePicker.RESULT_CODE_ITEMS && data != null) {
                    ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                }
                break;
        }
    }

    /**
     * 类别
     */
    private void showType() {
        final List<String> list = new ArrayList<>();
        list.add("套房");
        list.add("复式");
        list.add("排房");
        list.add("别墅");
        CommonSelectDialog orientationDialog = new CommonSelectDialog(this, list, new CommonSelectDialog.OnStringSelectListener() {
            @Override
            public void onStringSelect(String selectedString) {
                tvHouseType.setText(selectedString);
            }
        });
        orientationDialog.show();
    }

    /**
     * 室
     */
    private void showRooms() {
        final List<String> list = new ArrayList<>();
        list.add("一室");
        list.add("二室");
        list.add("三室");
        list.add("四室");
        list.add("五室");
        list.add("六室");
        CommonSelectDialog orientationDialog = new CommonSelectDialog(this, list, new CommonSelectDialog.OnStringSelectListener() {
            @Override
            public void onStringSelect(String selectedString) {
                tvRoomAmount.setText(selectedString);
            }
        });
        orientationDialog.show();
    }

    /**
     * 厅
     */
    private void showHall() {
        final List<String> list = new ArrayList<>();
        list.add("一厅");
        list.add("二厅");
        list.add("三厅");
        list.add("四厅");
        CommonSelectDialog orientationDialog = new CommonSelectDialog(this, list, new CommonSelectDialog.OnStringSelectListener() {
            @Override
            public void onStringSelect(String selectedString) {
                tvHall.setText(selectedString);
            }
        });
        orientationDialog.show();
    }

    /**
     * 厨
     */
    private void showKichen() {
        final List<String> list = new ArrayList<>();
        list.add("一厨");
        list.add("二厨");
        CommonSelectDialog orientationDialog = new CommonSelectDialog(this, list, new CommonSelectDialog.OnStringSelectListener() {
            @Override
            public void onStringSelect(String selectedString) {
                tvKitchen.setText(selectedString);
            }
        });
        orientationDialog.show();
    }

    /**
     * 厕
     */
    private void showWashroom() {
        final List<String> list = new ArrayList<>();
        list.add("一厕");
        list.add("二厕");
        list.add("三厕");
        list.add("四厕");
        list.add("五厕");
        CommonSelectDialog orientationDialog = new CommonSelectDialog(this, list, new CommonSelectDialog.OnStringSelectListener() {
            @Override
            public void onStringSelect(String selectedString) {
                tvToilet.setText(selectedString);
            }
        });
        orientationDialog.show();
    }

    /**
     * 阳台
     */
    private void showBalcony() {
        final List<String> list = new ArrayList<>();
        list.add("无阳台");
        list.add("一阳台");
        list.add("二阳台");
        list.add("三阳台");
        list.add("四阳台");
        list.add("五阳台");
        CommonSelectDialog orientationDialog = new CommonSelectDialog(this, list, new CommonSelectDialog.OnStringSelectListener() {
            @Override
            public void onStringSelect(String selectedString) {
                tvBalcony.setText(selectedString);
            }
        });
        orientationDialog.show();
    }

    /**
     * 花园
     */
    private void showGarden() {
        final List<String> list = new ArrayList<>();
        list.add("无花园");
        list.add("一花园");
        list.add("二花园");

        CommonSelectDialog orientationDialog = new CommonSelectDialog(this, list, new CommonSelectDialog.OnStringSelectListener() {
            @Override
            public void onStringSelect(String selectedString) {
                tvGarden.setText(selectedString);
            }
        });
        orientationDialog.show();
    }

    /**
     * 朝向
     */
    private void showOrientation() {
        final List<String> list = new ArrayList<>();
        list.add("正东");
        list.add("正南");
        list.add("正西");
        list.add("正北");
        list.add("东南");
        list.add("东北");
        list.add("西南");
        list.add("西北");
        CommonSelectDialog orientationDialog = new CommonSelectDialog(this, list, new CommonSelectDialog.OnStringSelectListener() {
            @Override
            public void onStringSelect(String selectedString) {
                tvOrientation.setText(selectedString);
            }
        });
        orientationDialog.show();
    }

    /**
     * 装修标准
     */
    private void showStandard() {
        final List<String> list = new ArrayList<>();
        list.add("毛坯");
        list.add("简装");
        list.add("精装");
        CommonSelectDialog standardDialog = new CommonSelectDialog(this, list, new CommonSelectDialog.OnStringSelectListener() {
            @Override
            public void onStringSelect(String selectedString) {
                tvStandard.setText(selectedString);
            }
        });
        standardDialog.show();
    }

    /**
     * 有无电梯
     */
    private void showElevator() {
        final List<String> list = new ArrayList<>();
        list.add("有电梯");
        list.add("无电梯");
        CommonSelectDialog elevatorDialog = new CommonSelectDialog(this, list, new CommonSelectDialog.OnStringSelectListener() {
            @Override
            public void onStringSelect(String selectedString) {
                tvHasElevator.setText(selectedString);
            }
        });
        elevatorDialog.show();
    }

    /**
     * 年限
     */
    private void showYears() {
        final List<String> list = new ArrayList<>();
        list.add("住宅用地70年");
        list.add("商用地40年");
        list.add("商住两用40年");
        CommonSelectDialog elevatorDialog = new CommonSelectDialog(this, list, new CommonSelectDialog.OnStringSelectListener() {
            @Override
            public void onStringSelect(String selectedString) {
                tvPeriod.setText(selectedString);
            }
        });
        elevatorDialog.show();
    }

    /**
     * 建筑面积
     */
    private void showAreaDialog() {
        CommonInputNumDialog dialog = new CommonInputNumDialog(this, "㎡", new CommonInputNumDialog.OnConfirmListener() {
            @Override
            public void onConfirm(String selectedString) {
                tvArea.setText(selectedString);
            }
        });
        dialog.show();
    }

    /**
     * 套内面积
     */
    private void showInnerAreaDialog() {
        CommonInputNumDialog dialog = new CommonInputNumDialog(this, "㎡", new CommonInputNumDialog.OnConfirmListener() {
            @Override
            public void onConfirm(String selectedString) {
                tvInnerArea.setText(selectedString);
            }
        });
        dialog.show();
    }

    /**
     * 均价
     */
    private void showAveragePriceDialog() {
        CommonInputNumDialog dialog = new CommonInputNumDialog(this, "元/㎡", new CommonInputNumDialog.OnConfirmListener() {
            @Override
            public void onConfirm(String selectedString) {
                tvPrice.setText(selectedString);
            }
        });
        dialog.show();
    }

    /**
     * 总价
     */
    private void showTotalPriceDialog() {
        CommonInputNumDialog dialog = new CommonInputNumDialog(this, "万元/套", new CommonInputNumDialog.OnConfirmListener() {
            @Override
            public void onConfirm(String selectedString) {
                tvTotalMoney.setText(selectedString);
            }
        });
        dialog.show();
    }


    /**
     * 标题
     */
    private void showTitle() {
        CommonInputDialog dialog = new CommonInputDialog(this, "请输入标题", new CommonInputDialog.OnConfirmListener() {
            @Override
            public void onConfirm(String selectedString) {
                tvTitle.setText(selectedString);
            }
        });
        dialog.show();
    }


    /**
     * 房源介绍
     */
    private void showDescription() {
        CommonInputDialog dialog = new CommonInputDialog(this, "请输入房源介绍", new CommonInputDialog.OnConfirmListener() {
            @Override
            public void onConfirm(String selectedString) {
                tvProfile.setText(selectedString);
            }
        });
        dialog.show();
    }


    /**
     * 地址
     */
    private void showAddress() {
        CommonInputDialog dialog = new CommonInputDialog(this, "请输入房源地址", new CommonInputDialog.OnConfirmListener() {
            @Override
            public void onConfirm(String selectedString) {
                tvAddress.setText(selectedString);
            }
        });
        dialog.show();
    }

    /**
     * 楼层
     */
    private void showFloor() {
        FloorNumDialog dialog = new FloorNumDialog(this, new FloorNumDialog.OnConfirmListener() {
            @Override
            public void onConfirm(String floor, String totalFloor) {
                floorNum = floor;
                totalFloorNum = totalFloor;
                tvFloor.setText(floor + "/" + totalFloor);
            }

        });
        dialog.show();
    }

    /**
     * 房源特点
     */
    private void showFeature() {
        /**
         * 地铁房、学区房、满二、满五、精装修、毛坯、户型好、地段好、江景房
         */
        final List<String> list = new ArrayList<>();
        list.add("地铁房");
        list.add("学区房");
        list.add("满二");
        list.add("满五");
        list.add("精装修");
        list.add("毛坯");
        list.add("户型好");
        list.add("地段好");
        list.add("江景房");
        CommonTagDialog dialog = new CommonTagDialog(this, list, new CommonTagDialog.OnConfirmListener() {
            @Override
            public void onConfirm(List<String> list) {
                mFeatureList.clear();
                mFeatureList.addAll(list);
                showFeatureTag();
            }
        });
        dialog.show();
    }

    private void showFeatureTag(){
        String tags="";
        for(String tag:mFeatureList){
            tags=tags+tag+" ";
        }
        tvFeature.setText(tags);
    }

    private void showPicture() {
        ImagePicker.getInstance().setMultiMode(true);
        Intent intent = new Intent(this, ImageGridActivity.class);
        startActivityForResult(intent, CHOOSE_PIC);
    }
}
