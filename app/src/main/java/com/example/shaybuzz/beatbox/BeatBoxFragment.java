package com.example.shaybuzz.beatbox;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaybuzz.beatbox.databinding.FragmentBeatBoxBinding;
import com.example.shaybuzz.beatbox.databinding.ListItemSoundBinding;

import java.util.List;

/**
 * Created by shaybuzz on 20/01/2018.
 */

public class BeatBoxFragment extends Fragment {

    public static BeatBoxFragment newInstance() {
        Bundle args = new Bundle();
        BeatBoxFragment fragment = new BeatBoxFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // View view = inflater.inflate(R.layout.fragment_beat_box, container, false);
        FragmentBeatBoxBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_beat_box, container, false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        BeatBox beatBox = new BeatBox(getActivity());
        binding.recyclerView.setAdapter(new SoundsAdapter(beatBox.getSounds()));
        return binding.getRoot();
    }

    private class SoundViewHolder extends RecyclerView.ViewHolder{
        private ListItemSoundBinding binding;

        public SoundViewHolder(ListItemSoundBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.setSoundViewModel(new SoundViewModel(new BeatBox(getActivity())));
        }

        public void bind(Sound sound){
            binding.getSoundViewModel().setSound(sound);
            binding.executePendingBindings();
       }
    }

    private class SoundsAdapter extends RecyclerView.Adapter<SoundViewHolder>{
        private List<Sound> soundsList;

        public SoundsAdapter(List<Sound> soundsList){
            this.soundsList = soundsList;
        }

        @Override
        public SoundViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ListItemSoundBinding binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.list_item_sound, parent, false);
            return new SoundViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(SoundViewHolder holder, int position) {
            holder.bind(soundsList.get(position));
        }

        @Override
        public int getItemCount() {
            return soundsList.size();
        }
    }
}
