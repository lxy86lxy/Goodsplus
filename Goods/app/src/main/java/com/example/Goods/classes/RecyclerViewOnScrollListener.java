package com.example.Goods.classes;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public  class RecyclerViewOnScrollListener extends RecyclerView.OnScrollListener {
    //监听回调
    private UpPullOnScrollListener listener;

    public RecyclerViewOnScrollListener(UpPullOnScrollListener listener) {
        this.listener = listener;
    }

    boolean isUpScroll = false; //是否正在上滑标记
    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();

        if (newState == RecyclerView.SCROLL_STATE_IDLE) { //当前未滑动

            int itemCount = manager.getItemCount(); //总数
            int lastItemPosition = manager.findLastCompletelyVisibleItemPosition();//最后显示的位置

            if (lastItemPosition == (itemCount - 1) && isUpScroll) {
                listener.onLoadMore();
            }
            int fristItemPosition = manager.findFirstCompletelyVisibleItemPosition();//第一个显示的位置
            if (fristItemPosition == (0) && !isUpScroll){
                listener.onRefresh();
            }
        }
    }
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        // 大于0表示正在向上滑动，小于等于0表示停止或向下滑动
        isUpScroll = dy > 0;
    }

    public interface UpPullOnScrollListener {
        public  void onLoadMore() ; //上拉加载更多的方法
        public   void onRefresh() ; //下拉刷新的方法
    }

}
