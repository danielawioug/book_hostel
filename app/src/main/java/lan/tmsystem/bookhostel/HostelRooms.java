package lan.tmsystem.bookhostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lan.tmsystem.bookhostel.data.DataManager;
import lan.tmsystem.bookhostel.data.Hostel;

public class HostelRooms extends AppCompatActivity {

    final DataManager mDb = DataManager.getInstance();
    private List<String> mD;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel_rooms);
        mD = getIntent().getStringArrayListExtra("rooms");
        String price = getIntent().getStringExtra("price");
        TextView singRoomNum = findViewById(R.id.txt_sing_num_room);
        TextView doubRoomNum = findViewById(R.id.txt_doub_num_room);
        TextView singRoomPrice = findViewById(R.id.txt_sing_room_price);
        TextView doubRoomPrice = findViewById(R.id.txt_doub_room_price);
        Button singBook = findViewById(R.id.btn_sing_book_room);
        Button doubBook = findViewById(R.id.btn_doub_book_room);

        if(mD.size() > 0){
            singRoomNum.setText(mD.get(0) + " Rooms Available");
            doubRoomNum.setText(mD.get(1) + " Rooms Available");
            doubRoomPrice.setText(Integer.parseInt(price) + 150000 + "/=");
            doubRoomPrice.setTextSize(24);
            singRoomPrice.setText(Integer.parseInt(price) + "/=");
            singRoomPrice.setTextSize(24);
            singBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PaymentsActivity.class);
                    intent.putExtra("price", Integer.parseInt(price));
                    v.getContext().startActivity(intent);
                }
            });
            doubBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PaymentsActivity.class);
                    intent.putExtra("price", Integer.parseInt(price) + 150000);
                    v.getContext().startActivity(intent);
                }
            });
        }

        ImageButton btnBack = findViewById(R.id.btn_back_room);

        btnBack.setOnClickListener(v -> {
            onBackPressed();
        });
    }
}