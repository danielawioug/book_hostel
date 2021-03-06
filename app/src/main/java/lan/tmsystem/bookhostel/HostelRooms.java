package lan.tmsystem.bookhostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.List;
import java.util.Map;

import lan.tmsystem.bookhostel.data.DataManager;
import lan.tmsystem.bookhostel.data.Hostel;

public class HostelRooms extends AppCompatActivity {

    final DataManager mDb = DataManager.getInstance();
    private List<String> mD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel_rooms);
        mD = getIntent().getParcelableExtra("hostel");
        TextView singRoomNum = findViewById(R.id.txt_sing_num_room);
        TextView doubRoomNum = findViewById(R.id.txt_doub_num_room);

        if(mD.size() > 0){

        }

        ImageButton btnBack = findViewById(R.id.btn_back_room);

        btnBack.setOnClickListener(v -> {
            onBackPressed();
        });
    }
}