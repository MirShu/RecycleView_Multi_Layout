package com.example.recycleview_multi_layout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_multi_layout.model.ResultModel;
import com.example.recycleview_multi_layout.R;

import java.util.List;

public  class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HEADER_VIEW = 0;
    private static final int NORMAL_VIEW = 1;
    private static final int TYPE_MIDDLE = 2;
    private static final int TYPE_MIDDLE_TWO = 3;

    private static final int TYPE_1 = 4;
    private static final int TYPE_2 = 5;
    private static final int TYPE_3 = 6;
    private static final int TYPE_4 = 7;
    private static final int TYPE_5 = 8;
    private static final int TYPE_6 = 9;
    private static final int TYPE_7 = 10;

    private View mHeaderView;
    private View mMiddleView;
    private View mMiddleView2;
    private List<ResultModel.ResultBean> listBeans;
    private OnClickListener mItemClickListener;
    BaseBindViewHolder baseBindViewHolder=new BaseBindViewHolder();
    private Context mContext;

    public void setItemClickListener(OnClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }


    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
    }

    public void setMiddleView(View middleView) {
        mMiddleView = middleView;
    }

    public void setMiddleView2(View middleView2) {
        mMiddleView2 = middleView2;
    }

    public Adapter(List<ResultModel.ResultBean> list, Context context) {
        this.listBeans = list;
        this.mContext = context;

    }


    @Override
    public int getItemCount() {
        if (listBeans != null && listBeans.size() != 0) {
            return listBeans.size() + 3;
        }
        return 0;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER_VIEW;
        }
        if (position == 5) {
            return TYPE_MIDDLE;
        }
        if (position == 10) {
            return TYPE_MIDDLE_TWO;
        } else {
            if (listBeans.get(getPosition(position)).getReplies_count() == 1) {
                return TYPE_1;
            } else if (listBeans.get(getPosition(position)).getReplies_count() == 2) {
                return TYPE_2;
            } else if (listBeans.get(getPosition(position)).getReplies_count() == 3) {
                return TYPE_3;
            } else if (listBeans.get(getPosition(position)).getReplies_count() == 4) {
                return TYPE_4;
            } else if (listBeans.get(getPosition(position)).getReplies_count() == 5) {
                return TYPE_5;
            } else if (listBeans.get(getPosition(position)).getReplies_count() == 6) {
                return TYPE_6;
            } else {
                return TYPE_7;
            }

        }
    }

    public int getPosition(int i) {
        if (i < 4) {
            return i - 1;
        }
        if (i > 4 && i < 10) {
            return i - 2;
        } else {
            return i - 3;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == HEADER_VIEW) {
            return new BaseViewHolder(mHeaderView);
        }
        if (mMiddleView != null && viewType == TYPE_MIDDLE) {
            return new BaseViewHolder(mMiddleView);
        }
        if (mMiddleView2 != null && viewType == TYPE_MIDDLE_TWO) {
            return new BaseViewHolder(mMiddleView2);
        }

        if (viewType == TYPE_1) {
            return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type1, null, false));
        } else if (viewType == TYPE_2) {
            return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type2, null, false));
        } else if (viewType == TYPE_3) {
            return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type3, null, false));
        } else if (viewType == TYPE_4) {
            return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type4, null, false));
        } else if (viewType == TYPE_5) {
            return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type5, null, false));
        } else if (viewType == TYPE_6) {
            return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type6, null, false));
        } else {
            return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type0, null, false));
        }


    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == HEADER_VIEW) {
            if (holder instanceof BaseViewHolder) {
                baseBindViewHolder.onBindViewHolder0(holder,listBeans);
            }
            return;
        }
        if (getItemViewType(position) == TYPE_MIDDLE) {
            if (holder instanceof BaseViewHolder) {

            }

            return;
        }
        if (getItemViewType(position) == TYPE_MIDDLE_TWO) {
            if (holder instanceof BaseViewHolder) {
                baseBindViewHolder.onBindTYPE_MIDDLE_TWO(holder,listBeans,mContext);
            }
            return;
        }




        if (getItemViewType(position) == TYPE_1) {
            if (holder instanceof BaseViewHolder) {
                baseBindViewHolder.onBindViewHolder1(holder,listBeans);
            }
            return;
        }
        if (getItemViewType(position) == TYPE_2) {
            if (holder instanceof BaseViewHolder) {
                baseBindViewHolder.onBindViewHolder2(holder,listBeans);
            }
            return;
        }

        if (getItemViewType(position) == TYPE_3) {
            if (holder instanceof BaseViewHolder) {
                baseBindViewHolder.onBindViewHolder3(holder,listBeans);
            }
            return;
        }

        if (getItemViewType(position) == TYPE_4) {
            if (holder instanceof BaseViewHolder) {
                baseBindViewHolder.onBindViewHolder4(holder,listBeans);
            }
            return;
        }



        if (getItemViewType(position) == TYPE_5) {
            if (holder instanceof BaseViewHolder) {
                baseBindViewHolder.onBindViewHolder5(holder,listBeans);
            }
            return;
        }


        if (getItemViewType(position) == TYPE_6) {
            if (holder instanceof BaseViewHolder) {
                baseBindViewHolder.onBindViewHolder6(holder,listBeans);
            }
            return;
        }

        final int pos = getRealPosition(holder);
        if (getItemViewType(position) == TYPE_7) {
            if (holder instanceof BaseViewHolder) {
                baseBindViewHolder.onBindViewHolder7(holder,listBeans);
                if (mItemClickListener == null) {
                    return;
                }
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mItemClickListener.onItemClick(v, pos);
                    }
                });
            }
            return;
        }

    }


    // 获取条目的真实位置
    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        if (position < 5) {
            return position - 1;
        }
        if (position > 5 && position < 10) {
            return position - 2;
        } else {
            return position - 3;
        }

    }

    interface OnClickListener {
        void onItemClick(View view, int position);
    }

}
