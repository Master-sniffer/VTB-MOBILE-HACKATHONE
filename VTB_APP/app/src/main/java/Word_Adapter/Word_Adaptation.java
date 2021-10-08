package Word_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vtb_app.R;
import com.example.vtb_app.Word;

import java.util.ArrayList;
import java.util.List;

public class Word_Adaptation extends RecyclerView.Adapter<Word_Adaptation.WordViewHolder> {

    private List<Word> words;

    public Word_Adaptation (){
        words = new ArrayList<>();
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.word_item_view, parent, false);

        return new WordViewHolder(view);
    }

    public void SetWords(List<Word> words){
        if (!this.words.isEmpty()){
            this.words.clear();
        }
        this.words.addAll(words);
        notifyDataSetChanged(); // идет перерисовка содержимого
    }


    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Word word = words.get(position);
        holder.bind(word);
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder {

        private TextView russianVersion;
        private TextView englishVersion;


        public WordViewHolder(@NonNull View itemView) {
            super(itemView);

            englishVersion = itemView.findViewById(R.id.Russian_word_1);
            russianVersion = itemView.findViewById(R.id.English_word_1);
        }

        public void bind(Word word) {
            englishVersion.setText(word.getEnglishWord());
            russianVersion.setText(word.getRussianWord());
        }
    }
}
