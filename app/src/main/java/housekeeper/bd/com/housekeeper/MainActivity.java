package housekeeper.bd.com.housekeeper;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import housekeeper.bd.com.housekeeper.db.DaoMaster;
import housekeeper.bd.com.housekeeper.db.DaoSession;
import housekeeper.bd.com.housekeeper.db.Person;
import housekeeper.bd.com.housekeeper.db.PersonDao;

public class MainActivity extends AppCompatActivity {

    private PersonDao personDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDb();
        setViews();
    }

    private void initDb() {
        //Drop all tables!!!
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "housekeeper.db", null);
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        personDao = daoSession.getPersonDao();
        Person person = new Person();
//        "kevin", "boss", "lantou", "housekeeper of familly"
        person.setName("kevin");
        person.setAlias("boss");
        person.setDescription("housekeeper of family");
        personDao.insert(person);
    }

    private void setViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "非常棒！", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        TextView test = (TextView) findViewById(R.id.test);
        List<Person> persons = personDao.loadAll();
        if (null != persons && persons.size() > 0) {

            StringBuffer sb = new StringBuffer();

            for (Person p :
                    persons) {
                sb.append("id:"+p.getId()+"  name:"+p.getName() + "  description: " + p.getDescription() + "\n");
            }

            test.setText(sb.toString());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, BillCreatorActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
