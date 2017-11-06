package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.R;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.adapters.ContactAdapter;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.ContactClickListener;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.HomePageView;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.presenters.HomePagePresenter;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.services.ContactsMemory;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.utils.Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomePageActivity extends AppCompatActivity implements HomePageView,
        ContactClickListener {
    public static final String CONTACT_ID = "ID_CONTACT_TO_EDIT";
    private HomePagePresenter presenter;

    @BindView(R.id.searchView_contact)
    public SearchView searchView_contacts;

    @BindView(R.id.recyclerView_contacts)
    public RecyclerView recyclerView_contacts;

    private RecyclerView.LayoutManager layoutManager;
    private ContactAdapter adapter;
    private ArrayList<Contact> contacts;


    //- Callbacks Activity lifecycle ---------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ButterKnife.bind(this);

        if (Utils.isNull(presenter)) {
            presenter = new HomePagePresenter(ContactsMemory.getInstance());
        }

        presenter.attach(this);

        contacts = new ArrayList<>();

        recyclerView_contacts.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView_contacts.setLayoutManager(layoutManager);
        adapter = new ContactAdapter(contacts, this);
        recyclerView_contacts.setAdapter(adapter);

        searchView_contacts.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.search(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    presenter.update();
                } else {
                    presenter.search(newText);
                }
                return true;
            }
        });

        presenter.update();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
        if (!isChangingConfigurations())
            presenter = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.update();
    }

    //- Callbacks Presenter ------------------------------------------------------------------------

    @Override
    public void onUpdateContacts(ArrayList<Contact> list) {
        contacts.clear();
        contacts.addAll(list);
        adapter.notifyDataSetChanged();
    }


    //- Callbacks Activity view --------------------------------------------------------------------

    @OnClick(R.id.button_add)
    public void onClickAddNewEntryButton() {
        Intent intent = new Intent(this, AddNewEntryActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClickEdit(int position) {
        Intent intent = new Intent(this, EditEntryActivity.class);
        intent.putExtra(CONTACT_ID, contacts.get(position).id);
        startActivity(intent);
    }


}
