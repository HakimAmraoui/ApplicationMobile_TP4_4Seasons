package sc.teach.a4seasons;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import sc.teach.a4seasons.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    public ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Créer un adaptateur qui retourne un fragment
        // pour chacune des sections de l'activité
        SectionsPagerAdapter sectionsPagerAdapter =
                new SectionsPagerAdapter(this, getSupportFragmentManager());
        // L’adaptateur va gérer les fragments à créer et à gérer au travers du gestionnaire de
        // fragments (FragmentManager) du système. C’est la raison du paramètre lors de la création
        // de l’instance de SectionsPagerAdapter.
        // dire au viewpager d'utiliser cet adaptateur
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

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
        if (id == R.id.action_home) {
            Snackbar.make(viewPager, "Home", Snackbar.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_account) {
            Snackbar.make(viewPager, "Account", Snackbar.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_settings) {
            Snackbar.make(viewPager, "Settings", Snackbar.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}