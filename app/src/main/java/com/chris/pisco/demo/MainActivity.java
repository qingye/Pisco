package com.chris.pisco.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.chris.pisco.Pisco;
import com.chris.pisco.model.OnPiscoListener;
import com.chris.pisco.model.Options;
import com.chris.pisco.model.processer.CenterCorpProcesser;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageView a, b, c, d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
    }

    private void test() {
        imageView = findViewById(R.id.image);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        Log.e("chris", "width = " + a.getWidth() + ", height = " + a.getHeight());

        String[] pic = {
                "https://image-c.weimobwmc.com/jingxuan-file/21ce409026174b29828cfc113d00fd18.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/9c00219ec6354c078fe75c964b4553c7.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/8481223a9d0d4db883df714d8c9bc87c.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/ad4197fbc2ff4b79a5546f9ae2874031.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/2b49e16dea374f7696199374c7fb1a69.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/b400e2da235940b3bd994f15581dc018.png?mdw=750&mdh=52",
                "https://image-c.weimobwmc.com/jingxuan-file/562d20978f54412fbc1e1858e3d1d157.png?mdw=650&mdh=380",
                "https://image-c.weimobwmc.com/jingxuan-file/72b076a85b9d4d5aa7d10812c9a78205.png?mdw=650&mdh=380",
                "https://image-c.weimobwmc.com/jingxuan-file/92e9cf9ea3df48289d77a07480027e36.png?mdw=650&mdh=380",
                "https://image-c.weimobwmc.com/jingxuan-file/72b076a85b9d4d5aa7d10812c9a78205.png?mdw=650&mdh=380",
                "https://image-c.weimobwmc.com/jingxuan-file/562d20978f54412fbc1e1858e3d1d157.png?mdw=650&mdh=380",
                "https://image-c.weimobwmc.com/jingxuan-file/58f4951c6d4f4a8ca48b3960eb2f7219.png?mdw=750&mdh=20",
                "https://image-c.weimobwmc.com/jingxuan-file/851a63e2a28245b9b60a883a69b448f8.png?mdw=670&mdh=440",
                "https://image-c.weimobwmc.com/jingxuan-file/809e252ccbf044118bae1a53de03f1e0.png?mdw=670&mdh=440",
                "https://image-c.weimobwmc.com/jingxuan-file/0b72bfeefeaf48b690c24dd6548e2a3b.png?mdw=670&mdh=440",
                "https://image-c.weimobwmc.com/jingxuan-file/228bc569b05a46beaa59bfdca76a1c81.png?mdw=670&mdh=440",
                "https://image-c.weimobwmc.com/jingxuan-file/e3e51f8e7d124c7589e1f862f526cfad.png?mdw=670&mdh=440",
                "https://image-c.weimobwmc.com/jingxuan-file/4967e82ecb014aa7b98f0807d67ceefc.png?mdw=670&mdh=440",
                "https://image-c.weimobwmc.com/jingxuan-file/21ce409026174b29828cfc113d00fd18.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/311daa6545de4734921c19e7b42ce376.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/d5941d47bfd3411a9a20ee310af84149.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/d5941d47bfd3411a9a20ee310af84149.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/2613b7ae699140538d9a52e47e7ea026.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/2613b7ae699140538d9a52e47e7ea026.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/cdc3a58dc11d4cf3a5e0caa4d354e55b.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/8481223a9d0d4db883df714d8c9bc87c.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/141dacc982594f42b318dbfcc417f0cc.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/ecbeca74229d4441834af73d94c93792.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/d5941d47bfd3411a9a20ee310af84149.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/eeed551f81864e79829594c86f97e262.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/cbb6e80248f84152b56769b06fa3f5b0.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/ed277a3fdf4849f292b7db9b2c5fdf6a.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/589d8ca846de4c3abe16c0a4e76e34e6.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/82338d644b40477399d46f67bf51a726.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/2db832d78d8c442ca77dd32309c6dbfe.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/ca9391b9350d448c90d8567be30b6298.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/c85f5c1dcfda42e7887166ef23ddb463.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/82338d644b40477399d46f67bf51a726.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/589d8ca846de4c3abe16c0a4e76e34e6.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/f2901d039bee4f4ebe131caa7118eeb2.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/ed277a3fdf4849f292b7db9b2c5fdf6a.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/589d8ca846de4c3abe16c0a4e76e34e6.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/82338d644b40477399d46f67bf51a726.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/ed277a3fdf4849f292b7db9b2c5fdf6a.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/f2901d039bee4f4ebe131caa7118eeb2.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/2db832d78d8c442ca77dd32309c6dbfe.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/da162d0b7cd440689565047551378bde.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/80d3505cca4f4b5583a43ba71fd7681b.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/adf8e752176c4e068bb431eec8cdb2bf.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/2613b7ae699140538d9a52e47e7ea026.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/8e8ff58c8314486c8d38b80e40195197.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/cdc3a58dc11d4cf3a5e0caa4d354e55b.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/61517584faa944648a8b064ae352b8a7.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/1adf7695be6f48538ce7cdcaf917b3b4.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/8d9afba61f6445acbde7ec6a6b986456.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/61517584faa944648a8b064ae352b8a7.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/cdc3a58dc11d4cf3a5e0caa4d354e55b.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/8d9afba61f6445acbde7ec6a6b986456.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/1adf7695be6f48538ce7cdcaf917b3b4.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/03230d1e4a8a485c89fec198242dbc26.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/2a120bf41844490da6a5cd967089de85.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/d1ede3f8f5d14247980ce3d85d67ce69.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/b3010feb1b414e02bac809106138a2ae.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/542b982b1ec34bb1a1e0ac60ff5498c3.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/9c00219ec6354c078fe75c964b4553c7.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/311daa6545de4734921c19e7b42ce376.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/d5941d47bfd3411a9a20ee310af84149.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/d5941d47bfd3411a9a20ee310af84149.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/2613b7ae699140538d9a52e47e7ea026.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/2613b7ae699140538d9a52e47e7ea026.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/cdc3a58dc11d4cf3a5e0caa4d354e55b.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/b4f37787e44c4fe48a2bed8aa81bc94a.png?mdw=200&mdh=200",
                "https://image-c.weimobwmc.com/jingxuan-file/1bb759c8283f4b58bdb932b202d83647.jpg?mdw=400&mdh=400",
                "https://image-c.weimobwmc.com/jingxuan-file/d5941d47bfd3411a9a20ee310af84149.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/eeed551f81864e79829594c86f97e262.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/d5941d47bfd3411a9a20ee310af84149.jpg?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/139e33cdf3234d1384d42fd4f7592fb7.png?mdw=690&mdh=118",
                "https://image-c.weimobwmc.com/jingxuan-file/aff6d927607f469f8051f470bbd9e596.png?mdw=200&mdh=200",
                "https://image-c.weimobwmc.com/jingxuan-file/9026fdf0127648eea1b0647d9ad894e8.jpg?mdw=480&mdh=800",
                "https://image-c.weimobwmc.com/jingxuan-file/57e9d8fa3d444ce8826a6f7beef92318.jpg?mdw=200&mdh=200",
                "https://image-c.weimobwmc.com/jingxuan-file/92e5935f8c2b4ea5b533dbf26a0d12c0.jpg?mdw=300&mdh=300",
                "https://image-c.weimobwmc.com/jingxuan-file/b2e1f21458ca4eaea1d03ae6a7f41a49.jpg?mdw=200&mdh=200",
                "https://image-c.weimobwmc.com/jingxuan-file/b4f37787e44c4fe48a2bed8aa81bc94a.png?mdw=200&mdh=200",
                "https://image-c.weimobwmc.com/jingxuan-file/ef40b5fa73704d54958bd609f082dce2.jpg?imageView2/2/w/200/h/200&mdw=400&mdh=400",
                "https://image-c.weimobwmc.com/jingxuan-file/1bb759c8283f4b58bdb932b202d83647.jpg?mdw=400&mdh=400",
                "https://image-c.weimobwmc.com/jingxuan-file/52ae4dfaadf0479f9bedb94ce479514f.jpg?imageView2/2/w/200/h/200&mdw=1440&mdh=1080",
                "https://image-c.weimobwmc.com/jingxuan-file/fc97fe9f4a544e12ba8a4ec8aacee318?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/42167e8a3b6d4ce0aa0a5d9419e34110?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/b633a3a6144d489fa90c453e77e38aee?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/6963c05c0ab04e599a8e11993d3e5436?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/6c5a69ff732345b8b5a3e73be4057a47?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/79a558554de04215bace24a2c0702c6a?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/c9f998820007403bb23fef6f1958d591?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/e7cf30a4138c444da9f90045bf0f1cfb?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/6b83eefd795b40659077693e091f85d5?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/ab63bedc8c284b899debb9683f9b7ced?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/83e45e1a7f834a36be1f1b25b49c3d29?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/d2a8796784734487b8e831ac7202ff00?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/7d84f77d7c81404d9883a7655e8a628d?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/aa151043b0d54b6b92527b7a31078f50?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/bc6b65fd92424ccf852f25924e11eb3e?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/f1f14687776e4aeea4c72d7c6ea2ef78?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/78e2e36aca8049f38328726d9664cf56?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/bf9c39e91ee840ba82d32c16623f83f8?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/0c4506190b2a414da2801b215c2dfb4e?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/12585e7411944ddf94eb016c77cb0430?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/3a89f4aab9664ce893f64fe646cad3d3?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/3be8577e985b448d8465a9cf0972282a?mdw=750&mdh=750",
                "https://image-c.weimobwmc.com/jingxuan-file/1cb13da757714bdb9b0b8cde4ab96894?mdw=750&mdh=709",
                "https://image-c-dev.weimobwmc.com/dev-jingxuan-file/e3f604f8bd0248efbf626652938feb2c.jpg?mdw=750&mdh=1728",
                "https://image-c.weimobwmc.com/jingxuan-file/21ce409026174b29828cfc113d00fd18.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/9c00219ec6354c078fe75c964b4553c7.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/8481223a9d0d4db883df714d8c9bc87c.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/ad4197fbc2ff4b79a5546f9ae2874031.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/2b49e16dea374f7696199374c7fb1a69.png?mdw=44&mdh=44",
                "https://image-c.weimobwmc.com/jingxuan-file/b400e2da235940b3bd994f15581dc018.png?mdw=750&mdh=52",
                "https://image-c.weimobwmc.com/jingxuan-file/562d20978f54412fbc1e1858e3d1d157.png?mdw=650&mdh=380",
                "https://image-c.weimobwmc.com/jingxuan-file/72b076a85b9d4d5aa7d10812c9a78205.png?mdw=650&mdh=380",
                "https://image-c.weimobwmc.com/jingxuan-file/92e9cf9ea3df48289d77a07480027e36.png?mdw=650&mdh=380",
                "https://image-c.weimobwmc.com/jingxuan-file/72b076a85b9d4d5aa7d10812c9a78205.png?mdw=650&mdh=380",
                "https://image-c.weimobwmc.com/jingxuan-file/562d20978f54412fbc1e1858e3d1d157.png?mdw=650&mdh=380",
                "https://image-c.weimobwmc.com/jingxuan-file/dac23ba783774e4581129d9506d50b36.png?mdw=670&mdh=440"
        };

        for (String url : pic) {
            Pisco.INSTANCE.load(imageView, url,
                    new Options(new CenterCorpProcesser()),
                    new OnPiscoListener() {
                        @Override
                        public void onLoadFinish() {
                        }
                    });

            Pisco.INSTANCE.load(
                    a, url,
                    new Options(new CenterCorpProcesser()),
                    new OnPiscoListener() {
                        @Override
                        public void onLoadFinish() {
                        }
                    });
            Pisco.INSTANCE.load(
                    b, url,
                    new Options(new CenterCorpProcesser()),
                    new OnPiscoListener() {
                        @Override
                        public void onLoadFinish() {
                        }
                    });

            Pisco.INSTANCE.load(
                    c, url,
                    new Options(new CenterCorpProcesser()),
                    new OnPiscoListener() {
                        @Override
                        public void onLoadFinish() {
                        }
                    });

            Pisco.INSTANCE.load(
                    d, url,
                    new Options(new CenterCorpProcesser()),
                    new OnPiscoListener() {
                        @Override
                        public void onLoadFinish() {
                        }
                    });
        }
    }
}
