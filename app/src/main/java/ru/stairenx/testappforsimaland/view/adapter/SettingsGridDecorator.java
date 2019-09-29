package ru.stairenx.testappforsimaland.view.adapter;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

public class SettingsGridDecorator extends ItemDecoration {

  private int spaceHeight;

  public SettingsGridDecorator(int spaceHeight) {
    this.spaceHeight = spaceHeight;
  }

  @Override
  public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                             @NonNull RecyclerView parent, @NonNull State state) {
    super.getItemOffsets(outRect, view, parent, state);
    outRect.left = spaceHeight;
    outRect.right = spaceHeight;
    outRect.bottom = spaceHeight;
    outRect.top = spaceHeight;
  }
}
