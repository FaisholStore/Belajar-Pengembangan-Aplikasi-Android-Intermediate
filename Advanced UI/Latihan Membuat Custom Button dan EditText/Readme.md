# Extend View

Ketika Anda meng-extend kelas `AppCompatEditText` atau `AppCompatButton`, Anda bisa memanggil
metode-metode yang ada di dalam kelas tersebut. Seperti:

- `setBackground`
- `setTextColor`
- `setTextSize`
- `setGravity`
- `setText`
- `setHint`
- `setInputType`
- `addTextChangeListener`
- `setOnTouchListener`
- `getText`
- dll

Jika di dalam Activity, Anda perlu memanggil komponennya baru memanggil metode yang ada pada kelas
tersebut. Seperti ini:

```java
myEditText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // Implement your code here
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // Implement your code here
    }

    @Override
    public void afterTextChanged(Editable s) {
        // Implement your code here
    }
});

myButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Implement your code here
    }
});
