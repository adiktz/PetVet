package com.dataction.petvet.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.dataction.petvet.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class PetRegistrationActivityFragment extends Fragment {

    @Bind(R.id.species_dropdown)
    Spinner speciesSpinner;

    @Bind(R.id.breed_dropdown)
    Spinner breedSpinner;

    List<String> speciesList;
    public PetRegistrationActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String [] species = {"dog","cat","bull"};
        speciesList = new ArrayList<>();
        speciesList.add(species[0]);
        speciesList.add(species[1]);
        speciesList.add(species[2]);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pet_registration, container, false);
        ButterKnife.bind(this, view);
        SpeciesAdapter speciesAdapter = new SpeciesAdapter();
        speciesAdapter.addItems(speciesList);
        speciesSpinner.setAdapter(speciesAdapter);

        BreedAdapter breedAdapter = new BreedAdapter();
        breedAdapter.addItems(speciesList);
        breedSpinner.setAdapter(breedAdapter);
        return view;
    }

    private class SpeciesAdapter extends BaseAdapter {
        private List<String> mItems = new ArrayList<>();

        public void clear() {
            mItems.clear();
        }

        public void addItem(String yourObject) {
            mItems.add(yourObject);
        }

        public void addItems(List<String> yourObjectList) {
            mItems.addAll(yourObjectList);
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getDropDownView(int position, View view, ViewGroup parent) {
            if (view == null || !view.getTag().toString().equals("DROPDOWN")) {
                view = getActivity().getLayoutInflater().inflate(R.layout.ui_spinner_item_dropdown, parent, false);
                view.setTag("DROPDOWN");
            }

            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getTitle(position));

            return view;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null || !view.getTag().toString().equals("NON_DROPDOWN")) {
                view = getActivity().getLayoutInflater().inflate(R.layout.
                        ui_spinner_item, parent, false);
                view.setTag("NON_DROPDOWN");
            }
            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getTitle(position));
            return view;
        }

        private String getTitle(int position) {
            return position >= 0 && position < mItems.size() ? mItems.get(position) : "";
        }
    }

    private class BreedAdapter extends BaseAdapter {
        private List<String> mItems = new ArrayList<>();

        public void clear() {
            mItems.clear();
        }

        public void addItem(String yourObject) {
            mItems.add(yourObject);
        }

        public void addItems(List<String> yourObjectList) {
            mItems.addAll(yourObjectList);
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getDropDownView(int position, View view, ViewGroup parent) {
            if (view == null || !view.getTag().toString().equals("DROPDOWN")) {
                view = getActivity().getLayoutInflater().inflate(R.layout.ui_spinner_item_dropdown, parent, false);
                view.setTag("DROPDOWN");
            }

            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getTitle(position));

            return view;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null || !view.getTag().toString().equals("NON_DROPDOWN")) {
                view = getActivity().getLayoutInflater().inflate(R.layout.
                        ui_spinner_item, parent, false);
                view.setTag("NON_DROPDOWN");
            }
            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getTitle(position));
            return view;
        }

        private String getTitle(int position) {
            return position >= 0 && position < mItems.size() ? mItems.get(position) : "";
        }
    }
}
