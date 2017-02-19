package com.toda.broker;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.toda.broker.view.UnitDescriptionLayout;
import com.toda.broker.view.dialog.CommonInputDialog;
import com.toda.broker.view.dialog.CommonSelectDialog;

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
    @BindView(R.id.ll_phone)
    LinearLayout llPhone;
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
    }

    @OnClick({R.id.ll_phone, R.id.ll_title, R.id.ll_address, R.id.ll_landmark, R.id.ll_profile, R.id.ll_type, R.id.ll_bedroom, R.id.ll_hall, R.id.ll_kitchen, R.id.ll_balcony, R.id.ll_garden,
            R.id.ll_area, R.id.ll_inner_area, R.id.ll_floor, R.id.ll_price, R.id.ll_total_price, R.id.ll_standard, R.id.ll_period, R.id.ll_has_elevator, R.id.ll_orientation,R.id.ll_toilet})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_phone:
                break;
            case R.id.ll_title:
                break;
            case R.id.ll_address:
                break;
            case R.id.ll_landmark:
                break;
            case R.id.ll_profile:
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
    private void showAreaDialog(){
        CommonInputDialog dialog=new CommonInputDialog(this, "㎡", new CommonInputDialog.OnConfirmListener() {
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
    private void showInnerAreaDialog(){
        CommonInputDialog dialog=new CommonInputDialog(this, "㎡", new CommonInputDialog.OnConfirmListener() {
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
    private void showAveragePriceDialog(){
        CommonInputDialog dialog=new CommonInputDialog(this, "元/㎡", new CommonInputDialog.OnConfirmListener() {
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
    private void showTotalPriceDialog(){
        CommonInputDialog dialog=new CommonInputDialog(this, "万元/套", new CommonInputDialog.OnConfirmListener() {
            @Override
            public void onConfirm(String selectedString) {
                tvTotalMoney.setText(selectedString);
            }
        });
        dialog.show();
    }
}
