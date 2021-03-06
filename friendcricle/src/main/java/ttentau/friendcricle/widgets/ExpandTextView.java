package ttentau.friendcricle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import ttentau.friendcricle.R;


/**
 * 可伸缩的textView
 * Created by ttent on 2017/2/28.
 */

public class ExpandTextView extends LinearLayout {

	private TextView mContentText;
	private TextView mTextPlus;
	private int showLines = 4;
	private boolean isExpand=false;
	private textStatuListener mListener;

	public ExpandTextView(Context context) {
		super(context);
		initView();
	}

	public ExpandTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public ExpandTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView();
	}

	private void initView() {
		setOrientation(VERTICAL);
		LayoutInflater.from(getContext()).inflate(R.layout.expandtextview, this);
		mContentText = (TextView) findViewById(R.id.contentText);
		mTextPlus = (TextView) findViewById(R.id.textPlus);
		mTextPlus.setText("全文");
		mTextPlus.setVisibility(INVISIBLE);
		mTextPlus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String trim = mTextPlus.getText().toString().trim();
				if (trim.equals("全文")) {
					//mTextPlus.setVisibility(VISIBLE);
					mTextPlus.setText("收起");
					mContentText.setMaxLines(Integer.MAX_VALUE);
					isExpand = true;
				} else {
					//mTextPlus.setVisibility(VISIBLE);
					mContentText.setMaxLines(showLines);
					mTextPlus.setText("全文");
					isExpand = false;
				}
				if (mListener!=null){
					mListener.statusChange(isExpand);
				}
			}
		});

	}
	public void setText(final CharSequence text, final boolean dbIsExpand) {
		mContentText.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
			@Override
			public boolean onPreDraw() {
				mContentText.getViewTreeObserver().removeOnPreDrawListener(this);
				// mContentText.setHighlightColor(Color.BLUE);
				if (mContentText.getLineCount() <= showLines) {
					mTextPlus.setVisibility(GONE);
				} else {
					mContentText.setMaxLines(showLines);
					if (!dbIsExpand){
						mContentText.setMaxLines(showLines);
						mTextPlus.setText("全文");
						isExpand = false;
					}else {
						mTextPlus.setText("收起");
						mContentText.setMaxLines(Integer.MAX_VALUE);
						isExpand = true;
					}
					mTextPlus.setVisibility(VISIBLE);
				}

				return true;
			}
		});
		mContentText.setText(text, TextView.BufferType.SPANNABLE);
	}
	public interface textStatuListener {
		void statusChange(boolean isExpand);
	}
	public void setOntextStatuListener(textStatuListener listener) {
		mListener = listener;
	}
}
