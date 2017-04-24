package com.dualeh.mustafa.jishin_free.Fragments;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.dualeh.mustafa.jishin_free.R;
import com.dualeh.mustafa.jishin_free.Utilities.Earthquake;
import com.dualeh.mustafa.jishin_free.Utilities.EarthquakeAdapter;
import com.dualeh.mustafa.jishin_free.Utilities.EarthquakeLoader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class EarthquakeListTabFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Earthquake>> {


    private static final int EARTHQUAKE_LOADER_ID = 1;

    private EarthquakeAdapter mAdapter;

    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query";

    private TextView mEmptyStateTextView;
    private View rootView;

    public EarthquakeListTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Generate View using adapter helper
        rootView = inflater.inflate(R.layout.fragment_earthquake_list_tab, container, false);
        ListView earthquakeListView = (ListView) rootView.findViewById(R.id.list);
        mEmptyStateTextView = (TextView) rootView.findViewById(R.id.empty_view);
        //TODO Fix Null Reference

        // Create a new adapter that takes an empty list of earthquakes as input
        mAdapter = new EarthquakeAdapter(getActivity(), new ArrayList<Earthquake>());
        earthquakeListView.setAdapter(mAdapter);

        if (mEmptyStateTextView != null) {
            earthquakeListView.setEmptyView(mEmptyStateTextView);


            // Set an item click listener on the ListView
            earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    // Find the current earthquake that was clicked on
                    long viewId = view.getId();
                    Earthquake currentEarthquake = mAdapter.getItem(position);
                    //If map icon is clicked on a list item
                    if (viewId == R.id.imageButton) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        Double lat = currentEarthquake.getLatitude();
                        Double longi = currentEarthquake.getLongitude();
                        intent.setData(Uri.parse("geo:0,0?q=" + lat + "," + longi + "&z=15 (Epicentre of Earthquake)"));
                        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                            startActivity(intent);
                        }
                        //If share button is clicked on a list item
                    } else if (viewId == R.id.shareButton) {
                        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
                        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
                        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
                        String formattedDate = dateFormat.format(dateObject);
                        String formattedTime = timeFormat.format(dateObject);
                        //Open Share Intent
                        //TODO
                        //Share data in earthquake list item via another app
                        doShare("There was a magnitude " + currentEarthquake.getMagnitude() + " earthquake located " + currentEarthquake.getLocation() + " at " + formattedTime + " on " + formattedDate);

                    } else {
                        //do nothing

                    }
                }


            });


            // Get a reference to the ConnectivityManager to check state of network connectivity
            ConnectivityManager connMgr = (ConnectivityManager)
                    getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

            // Get details on the currently active default data network
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

            // If there is a network connection, fetch data
            if (networkInfo != null && networkInfo.isConnected()) {
                // Get a reference to the LoaderManager, in order to interact with loaders.
                LoaderManager loaderManager = getActivity().getLoaderManager();
                loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);
            } else {
                // Otherwise, display error
                // First, hide loading indicator so error message will be visible
                View loadingIndicator = rootView.findViewById(R.id.loading_indicator);
                loadingIndicator.setVisibility(View.GONE);

                // Update empty state with no connection error message
                mEmptyStateTextView.setText(R.string.no_internet_connection);
            }


        }
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //your code which you want to refresh
    }

    public void doShare(String shareBody) {
        // populate the share intent with data

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(intent, "Share via"));


    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().getLoaderManager().restartLoader(0, null, this);


    }

    @Override
    public Loader<List<Earthquake>> onCreateLoader(int i, Bundle bundle) {

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String daysBack = sharedPrefs.getString(
                getString(R.string.settings_number_of_days_key),
                getString(R.string.settings_number_of_days_default));
        //prevent shared preferences from saving excessively large number and crashing the app
        if (Integer.parseInt(daysBack) > 7300) {
            daysBack = "7300";
        }

        if (Integer.parseInt(daysBack) < 0) {
            daysBack = "0";
        }
        String minMagnitude = sharedPrefs.getString(
                getString(R.string.settings_min_magnitude_key),
                getString(R.string.settings_min_magnitude_default));

        String orderBy = sharedPrefs.getString(
                getString(R.string.settings_order_by_key),
                getString(R.string.settings_order_by_default)
        );
        String showLimit = sharedPrefs.getString(
                getString(R.string.settings_limit_by_key),
                getString(R.string.settings_limit_by_default)
        );

        if (Integer.parseInt(showLimit) > 30) {
            showLimit = "30";
        }
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -Integer.parseInt(daysBack));
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        Date todayminus = cal.getTime();
        String formattedDate = df2.format(todayminus);


        //build Uri Request String
        Uri baseUri = Uri.parse(USGS_REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();
        uriBuilder.appendQueryParameter("format", "geojson");
        uriBuilder.appendQueryParameter("limit", showLimit);
        uriBuilder.appendQueryParameter("starttime", formattedDate);
        uriBuilder.appendQueryParameter("minmag", minMagnitude);
        uriBuilder.appendQueryParameter("orderby", orderBy);
        uriBuilder.appendQueryParameter("minlatitude", "25");
        uriBuilder.appendQueryParameter("minlongitude", "130");
        uriBuilder.appendQueryParameter("maxlatitude", "45");
        uriBuilder.appendQueryParameter("maxlongitude", "150");

        return new EarthquakeLoader(getActivity(), uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> earthquakes) {
        // Hide loading indicator because the data has been loaded

        if (mEmptyStateTextView != null) {
            View loadingIndicator = rootView.findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            // Set empty state text to display "No earthquakes found."
            mEmptyStateTextView.setText(R.string.no_earthquakes);

            // Clear the adapter of previous earthquake data
            mAdapter.clear();

            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (earthquakes != null && !earthquakes.isEmpty()) {
                mAdapter.addAll(earthquakes);
            }
        }


    }

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {

    }
}

