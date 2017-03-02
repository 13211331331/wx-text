package com.hhl;
import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;



/**
 * @author HuangHL
 * @date 2017/3/2
 * @see
 */
public class CvsTest
{

    /**
     *
     CREATE TABLE [dbo].[Whir_U_Content_1](
     [Whir_U_Content_PID] [nvarchar](2048) NULL,
     [Title] [nvarchar](2048) NULL,
     [ImageUrl] [nvarchar](2048) NULL,
     [Content] [ntext] NULL,
     [MetaTitle] [nvarchar](512) NULL,
     [MetaKeyword] [nvarchar](512) NULL,
     [MetaDesc] [nvarchar](1024) NULL,
     [RedirectUrl] [nvarchar](2048) NULL,
     [EnableRedirectUrl] [bit] NULL,
     [TypeID] [nvarchar](64) NULL,
     [Sort] [bigint] NULL,
     [IsDel] [bit] NULL,
     [CreateDate] [datetime] NULL,
     [LinkUrl] [nvarchar](2048) NULL,
     [Source] [nvarchar](2048) NULL,
     [FileUrl] [nvarchar](2048) NULL,
     [CountNum] [int] NULL
     ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

     GO


     * @param a
     * @throws IOException
     */
    public static void main(String[] a) throws IOException
    {
        CsvReader r = new CsvReader("g://content.csv", ',', Charset.forName("UTF-8"));
        //读取表头
        r.readHeaders();
        //逐条读取记录，直至读完
        while (r.readRecord())
        {
            //读取一条记录
           // System.out.println(r.getRawRecord());
            //按列名读取这条记录的值
            //System.out.println("Whir_U_Content_PID:"+r.get("Whir_U_Content_PID"));


            System.out.println("Title:"+r.get("Title"));
            System.out.println("ImageUrl:"+r.get("ImageUrl"));
            System.out.println("Content:"+r.get("Content"));
            System.out.println("MetaTitle:"+r.get("MetaTitle"));
            System.out.println("MetaKeyword:"+r.get("MetaKeyword"));
            System.out.println("MetaDesc:"+r.get("MetaDesc"));
            System.out.println("RedirectUrl:"+r.get("RedirectUrl"));
            System.out.println("EnableRedirectUrl:"+r.get("EnableRedirectUrl"));
            System.out.println("TypeID:"+r.get("TypeID"));
            System.out.println("Sort:"+r.get("Sort"));
            System.out.println("IsDel:"+r.get("IsDel"));
            System.out.println("CreateDate:"+r.get("CreateDate"));
            System.out.println("LinkUrl:"+r.get("LinkUrl"));
            System.out.println("Source:"+r.get("Source"));
            System.out.println("FileUrl:"+r.get("FileUrl"));
            System.out.println("CountNum:"+r.get("CountNum"));
            System.out.println("==================================================");
            System.out.println("==================================================");
        }
        r.close();

    }
}
