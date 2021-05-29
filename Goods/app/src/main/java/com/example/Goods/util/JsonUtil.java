package com.example.Goods.util;

import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.webkit.WebView;

import com.example.Goods.R;
import com.example.Goods.classes.Banner;
import com.example.Goods.classes.Leader;
import com.example.Goods.classes.LeaderD;
import com.example.Goods.classes.Massage;
import com.example.Goods.classes.Passage;
import com.example.Goods.classes.Question;
import com.example.Goods.classes.Struct;
import com.example.Goods.string.Strings;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    //解析文章
    public ArrayList<Passage> JsonPassage(String jsonData) {
        ArrayList<Passage>passageList=new ArrayList<>();
        try {
            Log.d(Strings.TAG,"json成功");
           JSONObject jsonObject=new JSONObject(jsonData);
          JSONObject jsonObject11=jsonObject.getJSONObject("data");
          JSONArray jsonArray=jsonObject11.getJSONArray("datas");
            for (int i = 0; i < jsonArray.length(); i++) {
                Passage passage1=new Passage();
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                passage1.setChapterName(jsonObject1.getString("chapterName"));
                passage1.setNiceDate(jsonObject1.getString("niceDate"));
                JSONArray jsonArray1=jsonObject1.getJSONArray("tags");
                if (jsonArray1.length()>=1){
                    JSONObject jsonObject2=jsonArray1.getJSONObject(0);

                    List<Passage.TagsBean> tags=new ArrayList<Passage.TagsBean>();
                    Passage.TagsBean tagsBean=new Passage.TagsBean(jsonObject2.getString("name"),jsonObject2.getString("url"));

                    tags.add(tagsBean);

                    passage1.setTags(tags);
                }else {
                    List<Passage.TagsBean> tags=new ArrayList<Passage.TagsBean>();
                    Passage.TagsBean tagsBean=new Passage.TagsBean("123","1234567833");

                    tags.add(tagsBean);
                    passage1.setTags(tags);
                }
                passage1.setAudit(jsonObject1.getInt("audit"));
                Log.d("Json","audit is "+passage1.getAudit());//可以成功
                passage1.setAuthor(jsonObject1.getString("author"));
                Log.d("Json","author is "+passage1.getAuthor());//可以成功
                passage1.setId(jsonObject1.getInt("id"));//可以成功
                Log.d("Json","id is "+passage1.getId());
                passage1.setLink(jsonObject1.getString("link"));//可以成功
                Log.d("Json","like is "+passage1.getLink());
                passage1.setTitle(jsonObject1.getString("title"));//可以成功
                Log.d("Json","title is "+passage1.getTitle());
//                JSONArray jsonArray1=jsonObject1.getJSONArray("tags");
//                passage1.setTags((List<Passage.TagsBean>) jsonArray1);
                passageList.add(passage1);
            }
        } catch (JSONException e) {
            Log.d(Strings.TAG,"json失败");
            e.printStackTrace();
        }
//        Log.d("Json","title is "+passageList.get(0).getTitle());//成功
        Log.d(Strings.TAG,"返回成功");
    return  passageList;
    }

//解析问答
    public ArrayList<Question> JsonQuestion(String jsonData) {
        ArrayList<Question>passageList=new ArrayList<>();
        try {
            Log.d(Strings.TAG,"json成功");
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONObject jsonObject11=jsonObject.getJSONObject("data");
            JSONArray jsonArray=jsonObject11.getJSONArray("datas");
            for (int i = 0; i < jsonArray.length(); i++) {
                Question passage1=new Question();
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                passage1.setAudit(jsonObject1.getInt("audit"));
                Log.d("Json","audit is "+passage1.getAudit());//可以成功
                passage1.setAuthor(jsonObject1.getString("author"));
                Log.d("Json","author is "+passage1.getAuthor());//可以成功
                passage1.setId(jsonObject1.getInt("id"));//可以成功
                Log.d("Json","id is "+passage1.getId());
                passage1.setLink(jsonObject1.getString("link"));//可以成功
                Log.d("Json","like is "+passage1.getLink());
                passage1.setTitle(jsonObject1.getString("title"));//可以成功
                Log.d("Json","title is "+passage1.getTitle());
                //去除html的标识
                Spanned desc= Html.fromHtml(jsonObject1.getString("desc"));
                passage1.setDesc(desc.toString());

                passage1.setNiceDate(jsonObject1.getString("niceDate"));
//                JSONArray jsonArray1=jsonObject1.getJSONArray("tags");
//                passage1.setTags((List<Passage.TagsBean>) jsonArray1);
                passageList.add(passage1);
            }
        } catch (JSONException e) {
            Log.d(Strings.TAG,"json失败");
            e.printStackTrace();
        }
//        Log.d("Json","title is "+passageList.get(0).getTitle());//成功
        Log.d(Strings.TAG,"返回成功");
        return  passageList;
    }


//解析标签
    public ArrayList<Banner> JsonBanner(String jsonData) {
        ArrayList<Banner>passageList=new ArrayList<>();
        try {
            Log.d(Strings.TAG,"json成功");
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONArray jsonArray=jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                Banner passage1=new Banner();
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                passage1.setUrl(jsonObject1.getString("url"));//可以成功
                passage1.setImagePath(jsonObject1.getString("imagePath"));//可以成功
                passageList.add(passage1);
            }
        } catch (JSONException e) {
            Log.d(Strings.TAG,"json失败");
            e.printStackTrace();
        }
        Log.d(Strings.TAG,"返回成功");
        return  passageList;
    }

//解析项目
    public ArrayList<Leader> JsonLeader(String jsonData) {
        ArrayList<Leader>passageList=new ArrayList<>();
        try {
            Log.d(Strings.TAG,"json成功");
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONObject jsonObject11=jsonObject.getJSONObject("data");

            JSONArray jsonArray=jsonObject11.getJSONArray("datas");
            for (int i = 0; i < jsonArray.length(); i++) {
                Leader passage1=new Leader();
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                passage1.setAudit(jsonObject1.getInt("audit"));
                passage1.setAuthor(jsonObject1.getString("author"));Log.d("JsonLeader",passage1.getAuthor());
                passage1.setDesc(jsonObject1.getString("desc"));Log.d("JsonLeader",passage1.getDesc());
                passage1.setNiceDate(jsonObject1.getString("niceDate"));
                passage1.setEnvelopePic(jsonObject1.getString("envelopePic"));
                passage1.setId(jsonObject1.getInt("id"));//可以成功
                passage1.setLink(jsonObject1.getString("link"));//可以成功
                passage1.setTitle(jsonObject1.getString("title"));//可以成功

//                JSONArray jsonArray1=jsonObject1.getJSONArray("tags");
//                passage1.setTags((List<Passage.TagsBean>) jsonArray1);
                passageList.add(passage1);
            }
        } catch (JSONException e) {
            Log.d(Strings.TAG,"json失败");
            e.printStackTrace();
        }
//        Log.d("Json","title is "+passageList.get(0).getTitle());//成功
        Log.d(Strings.TAG,"返回成功");
        return  passageList;
    }

    //解析体系
    public ArrayList<Struct> JsonStruct(String jsonData) {
        ArrayList<Struct>passageList=new ArrayList<>();
        try {
            Log.d(Strings.TAG,"json成功");
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONArray jsonArray=jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                Struct passage1=new Struct();
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                JSONArray jsonArray1=jsonObject1.getJSONArray("children");
                for (int j = 0; j < jsonArray1.length(); j++) {
                    JSONObject jsonObject2=jsonArray1.getJSONObject(j);
                    String name=jsonObject2.getString("name");
                    int id=jsonObject2.getInt("id");
                    passage1.getIdList().add(id);
                    passage1.getNameList().add(name);
                }
                passageList.add(passage1);
            }
        } catch (JSONException e) {
            Log.d(Strings.TAG,"json失败");
            e.printStackTrace();
        }
        Log.d(Strings.TAG,"返回成功");
        return  passageList;
    }

    public ArrayList<LeaderD> JsonD(String jsonData) {
        ArrayList<LeaderD>passageList=new ArrayList<>();
        try {
            Log.d(Strings.TAG,"json成功");
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONArray jsonArray=jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                LeaderD passage1=new LeaderD();
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                JSONArray jsonArray1=jsonObject1.getJSONArray("articles");
                for (int j = 0; j < jsonArray1.length(); j++) {
                    JSONObject jsonObject2=jsonArray1.getJSONObject(j);
                    String name=jsonObject2.getString("link");

                    passage1.setLink(name);
                }
                passageList.add(passage1);
            }
        } catch (JSONException e) {
            Log.d(Strings.TAG,"json失败");
            e.printStackTrace();
        }
        Log.d(Strings.TAG,"返回成功");
        return  passageList;
    }
}

