package sc.teach.a4seasons.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import sc.teach.a4seasons.MainActivity;
import sc.teach.a4seasons.R;

/**
 * une instance de NatureFragment contient ici juste un label
 */
public class NatureFragment extends Fragment {
    // Les champs utilisés par chaque Fragment
    //Ils sont distincts pour chaque NatureFragment instancié
    private String title;
    private int page;
    /**
     * Pour la sauvegarde et la récupération des données
     * dans un Bundle
     */
    private static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";

    /**
     * Retourne une nouvelle instance de ce fragment
     * pour le numéro de section donné.
     */
    public static NatureFragment newInstance(int position, String title) {
        NatureFragment fragment = new NatureFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    // retrouver les valeurs des champs à partir du bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // C'est ici que l'on instantie la page demandee
        View view = inflater.inflate(R.layout.fragment_main, container, false);
//        TextView tvLabel = (TextView) view.findViewById(R.id.section_label);
//        tvLabel.setText(page + " -- " + title);

        ImageView image = (ImageView) view.findViewById(R.id.iamgeView);

        // On affiche les different element en fonction de la page
        switch (page) {
            case 0:
                image.setImageResource(R.drawable.summer_large);
                break;
            case 1:
                image.setImageResource(R.drawable.autumn_large);
                break;
            case 2:
                image.setImageResource(R.drawable.winter_large);
                break;
            case 3:
                image.setImageResource(R.drawable.spring_large);
                break;
            case 4:
                View viewSeasons = inflater.inflate(R.layout.fragment_seasons, container, false);

                ImageView image_summer = (ImageView) viewSeasons.findViewById(R.id.image_summer);
                image_summer.setImageResource(R.drawable.summer_large);

                ImageView image_autome = (ImageView) viewSeasons.findViewById(R.id.image_automne);
                image_autome.setImageResource(R.drawable.autumn_large);

                ImageView image_winter = (ImageView) viewSeasons.findViewById(R.id.image_winter);
                image_winter.setImageResource(R.drawable.winter_large);

                ImageView image_spring = (ImageView) viewSeasons.findViewById(R.id.image_spring);
                image_spring.setImageResource(R.drawable.spring_large);

                image_summer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity a = (MainActivity) getActivity();
                        a.viewPager.setCurrentItem(0);
                    }
                });

                image_autome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity a = (MainActivity) getActivity();
                        a.viewPager.setCurrentItem(1);
                    }
                });

                image_winter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity a = (MainActivity) getActivity();
                        a.viewPager.setCurrentItem(2);
                    }
                });

                image_spring.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity a = (MainActivity) getActivity();
                        a.viewPager.setCurrentItem(3);
                    }
                });

                return viewSeasons;
        }

        return view;
    }


}
