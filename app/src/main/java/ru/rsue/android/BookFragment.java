package ru.rsue.android;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class BookFragment extends Fragment {
    private Book mBook;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mReadedCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBook = new Book();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_book, container,
                false);
        mTitleField = (EditText)v.findViewById(R.id.book_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
// Здесь намеренно оставлено пустое место
            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mBook.setTitle(s.toString());
            }
            @Override
            public void afterTextChanged(Editable c) {
// И здесь тоже
            }
        });
        Locale locale = new Locale("ru");
        Locale.setDefault(locale);
        mDateButton = (Button)v.findViewById(R.id.book_date);
        mDateButton.setText(DateFormat.getDateInstance(DateFormat.LONG, locale).format(mBook.getDate()));
        mDateButton.setEnabled(false);
        mReadedCheckBox = (CheckBox)v.findViewById(R.id.book_readed);
        mReadedCheckBox.setOnCheckedChangeListener(new
          CompoundButton.OnCheckedChangeListener() {
          @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean
           isChecked) {
                // Назначение флага прочтения книги
          mBook.setReaded(isChecked);
         }
        });
        return v;
    }
}
