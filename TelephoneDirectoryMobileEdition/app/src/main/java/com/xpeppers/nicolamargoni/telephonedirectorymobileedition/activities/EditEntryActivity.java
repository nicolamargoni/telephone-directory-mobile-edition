package com.xpeppers.nicolamargoni.telephonedirectorymobileedition.activities;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.R;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.ContactView;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.interfaces.EditEntryView;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.presenters.ContactPresenter;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.presenters.EditEntryPresenter;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.services.ContactsMemory;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.xpeppers.nicolamargoni.telephonedirectorymobileedition.activities.HomePageActivity.CONTACT_ID;

public class EditEntryActivity extends AppCompatActivity implements EditEntryView, ContactView {

    private EditEntryPresenter presenter;
    private ContactPresenter contactPresenter;

    @BindView(R.id.input_layout_firstname)
    TextInputLayout textInputLayout_firstName;

    @BindView(R.id.editText_firstname)
    EditText editText_firstName;

    @BindView(R.id.input_layout_lastname)
    TextInputLayout textInputLayout_lastName;

    @BindView(R.id.editText_lasttname)
    EditText editText_lastName;

    @BindView(R.id.input_layout_telephone_number)
    TextInputLayout textInputLayout_telephoneNumber;

    @BindView(R.id.editText_telephone_number)
    EditText editText_telephoneNumber;

    //- Callbacks Activity lifecycle ---------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_entry);

        ButterKnife.bind(this);

        if (Utils.isNull(contactPresenter)) {
            contactPresenter = new ContactPresenter();
        }

        contactPresenter.attach(this);


        if (Utils.isNull(presenter)) {
            Intent intent = getIntent();
            presenter = new EditEntryPresenter(ContactsMemory.getInstance(),
                    intent.getIntExtra(CONTACT_ID, 0), contactPresenter);
        }

        presenter.attach(this);
        presenter.publish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
        if (!isChangingConfigurations())
            presenter = null;
    }

    //- Callbacks Activity View --------------------------------------------------------------------

    @OnClick(R.id.button_edit)
    public void onClickAddNewEntryButton() {
        Contact contactToEdit = new Contact(editText_firstName.getText().toString(),
                editText_lastName.getText().toString(),
                editText_telephoneNumber.getText().toString());
        presenter.editEntry(contactToEdit);
    }


    //- Implementation Interfaces  -----------------------------------------------------------------

    @Override
    public void setLastNameErrorText(String description) {
        textInputLayout_lastName.setError(description);
    }

    @Override
    public void setLastNameValid() {
        textInputLayout_lastName.setErrorEnabled(false);
    }

    @Override
    public void setLastNameText(String text) {
        editText_lastName.setText(text);
    }

    @Override
    public void setFirstNameErrorText(String description) {
        textInputLayout_firstName.setError(description);
    }

    @Override
    public void setFirtsNameValid() {
        textInputLayout_firstName.setErrorEnabled(false);
    }

    @Override
    public void setFirstNameText(String text) {
        editText_firstName.setText(text);
    }

    @Override
    public void setTelephoneNumberErrorText(String description) {
        textInputLayout_telephoneNumber.setError(description);
    }

    @Override
    public void setTelephoneNumberValid() {
        textInputLayout_telephoneNumber.setErrorEnabled(false);
    }

    @Override
    public void setTelephoneNumberText(String text) {
        editText_telephoneNumber.setText(text);
    }


    @Override
    public void onContactEdited() {
        onBackPressed();
    }
}
