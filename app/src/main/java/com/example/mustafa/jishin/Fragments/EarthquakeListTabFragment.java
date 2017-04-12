package com.example.mustafa.jishin.Fragments;

import android.app.Activity;
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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mustafa.jishin.R;
import com.example.mustafa.jishin.Utilities.Earthquake;
import com.example.mustafa.jishin.Utilities.EarthquakeAdapter;
import com.example.mustafa.jishin.Utilities.EarthquakeLoader;
import com.google.android.gms.plus.PlusOneButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static android.R.attr.button;


public class EarthquakeListTabFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Earthquake>> {
    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int EARTHQUAKE_LOADER_ID = 1;
    /**
     * Adapter for the list of earthquakes
     */
    private EarthquakeAdapter mAdapter;

    /**
     * URL for earthquake data from the USGS dataset
     */
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query";

    /**
     * TextView that is displayed when the list is empty
     */
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
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LoaderManager.enableDebugLogging(true);
        rootView = inflater.inflate(R.layout.fragment_earthquake_list_tab, container, false);
        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) rootView.findViewById(R.id.list);

        mEmptyStateTextView = (TextView) rootView.findViewById(R.id.empty_view);
        //TODO Fix Null Reference

        // Create a new adapter that takes an empty list of earthquakes as input
        mAdapter = new EarthquakeAdapter(getActivity(), new ArrayList<Earthquake>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(mAdapter);

        if (mEmptyStateTextView != null) {
            earthquakeListView.setEmptyView(mEmptyStateTextView);


            // Set an item click listener on the ListView, which sends an intent to a web browser
            // to open a website with more information about the selected earthquake.


            earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    // Find the current earthquake that was clicked on
                    long viewId = view.getId();
                    Earthquake currentEarthquake = mAdapter.getItem(position);
                    if (viewId == R.id.imageButton) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        Double lat = currentEarthquake.getLatitude();
                        Double longi = currentEarthquake.getLongitude();
                        intent.setData(Uri.parse("geo:0,0?q=" + lat + "," + longi + "(Epicentre of Earthquake)"));
                        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                            startActivity(intent);
                        }

                    } else if (viewId == R.id.shareButton) {
                        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
                        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
                        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
                        String formattedDate = dateFormat.format(dateObject);
                        String formattedTime = timeFormat.format(dateObject);
                        //Open Share Intent
                        //TODO
                        //last thing i  did was this
                        doShare("There was a magnitude " + currentEarthquake.getMagnitude() + " earthquake located " + currentEarthquake.getLocation() + " at " + formattedTime + " on " + formattedDate);

                    } else {


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


                // Initialize the loader. Pass in the int ID constant defined above and pass in null for
                // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
                // because this activity implements the LoaderCallbacks interface).
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

    public void doShare(String shareBody) {
        // populate the share intent with data

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(intent, "Share via"));


    }


    @Override
    public Loader<List<Earthquake>> onCreateLoader(int i, Bundle bundle) {

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String daysBack = sharedPrefs.getString(
                getString(R.string.settings_number_of_days_key),
                getString(R.string.settings_number_of_days_default));

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
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -Integer.parseInt(daysBack));
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        Date todayminus = cal.getTime();
        String formattedDate = df2.format(todayminus);

        Uri baseUri = Uri.parse(USGS_REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        uriBuilder.appendQueryParameter("format", "geojson");
        uriBuilder.appendQueryParameter("limit", "10");
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

        //TODO Fix Null Reference
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

