package com.zjj.mvpdemo.model;

import com.zjj.mvpdemo.contract.Contract;

import java.util.List;

public class WordModel implements Contract.Model {


    /**
     * name : cheeses
     * item : ["Abertam cheese","Acre","Adobera cheese","Afuega\\'l pitu","Akkawi","Allgäuer Bergkäse","Alto Alentejo","Anari cheese","Andean Aconcagua region","Anthotyros","Appenzell","Appenzeller","Ardrahan Cheese","Areesh","Asadero cheese","Asturias","Atleet","Aura","Ayibe","Azores","Añejo cheese","Babybel","Bandel","Basket cheese","Bałtycki","Beira Baixa","Belgium","Belo Sirenje","Bergenost","Bergkäse","Berner Alpkäse","Beyaz peynir","Bilozhar","Bjurholm, Sweden","Blå Gotland","Bonifaz","Brick cheese","Brunost","Brussels cheese","Bryndza","Bryndza Podhalańska","Brânză de Suhaia","Brânzǎ de burduf","Bukovinskyi","Bundz","Bursztyn","Burträsk","Butterkäse","Byaslag","Cabrales cheese","Cambozola","Cantabria","Caravane cheese","Castelo Branco cheese","Catalonia","Catupiry","Caş","Caşcaval","Chanco cheese","Chaqueño","Chechil","Cheddar Cheese","Cheese curds","Cherni Vit","Chhena","Chhurpi","Chiapas cheese","Chihuahua cheese","Chimay cheeses","Chloro","Chura kampo","Chura loenpa","Circassian cheese","Colby cheese","Colby-Jack cheese","Colorado","Colorado Blackie","Cotija cheese","Cottage cheese","Cougar Gold cheese","County Cork","Cream cheese","Crema","Cremoso cheese","Creole cream cheese","Crete","Criollo","Criollo cheese","Croatian island of Pag","Cuajada","Cup Cheese","Dahi Chhena","Danbo","Danish Blue","Dimsi","Dobrodar","Domiati","Edamski","Eesti Juust","Emmentaler","Esrom","Extremadura","Farmer cheese","Feta","Flower of Rajya","Fuerteventura, Canary Islands","Fynbo","Galicia","Gamalost","Gamonedo cheese","Garrotxa cheese","Gauda","Geitost","Government cheese","Goya","Gołka","Graviera","Grevé","Gruyère","Gryficki","Gräddost","Guayana Region","Guayanés cheese","Gudbrandsdalsost","Halloumi","Handkäse","Harzer","Hauskyjza","Havarti","Hellim","Herrgårdsost","Herve cheese","Hirtenkäse","Hoop cheese","Hushållsost","Höfðingi","Idiazábal cheese","Imsil","Jameed","Jarlsberg cheese","Jibneh Arabieh","Jāņi cheese","Kadaka juust","Kalari","Kalimpong cheese","Karaván","Kashkaval","Kashkawan","Kasseri","Kačkavalj","Kaşar","Kefalograviera","Kefalotyri","Kelle Peyniri (Balıkesir)","Kesong puti","Khoya","Kopanisti","Korall","Korbáčiky","Kortowski","Koryciński","Kravská hrudka","Kunik cheese","L\\'Etivaz","La Mancha, Castile\u2013La Mancha","La Serena cheese","Labne","Labneh","Land of Herve, Belgium","Lapland","Lappi","Latvijas","Le Wavreumont","Lechicki","Leipäjuusto","León","Liederkranz cheese","Lighvan cheese","Liliput","Limburger","Limburger cheese","Lingallin","Liptauer","Liptauer or Kőrözött","Liqvan","Livno cheese","Livno, Bosnia and Herzegovina","Liège, Belgium","Lolland","Lubuski","Lüneberg cheese","Majdoule","Majorero cheese","Malaka","Manchego cheese","Manouri","Maredsous cheese","Maribo","Mató cheese","Maytag Blue cheese","Mazurski","Menonita","Metsovone","Mihaliç","Milbenkäse","Minas","Mish","Mohant","Molbo","Mols","Mondseer","Monte Enebro cheese","Monterey Jack cheese","Moose cheese","Motal","Muenster cheese","Murcia","Murcian cheese","Myconos","Myzithra","Nablus","Nabulsi cheese","Nacho cheese","Navarre and Basque Country","Nguri","Norvegia","Nøkkelost","Năsal cheese","Oaxaca cheese","Oka","Olomoucké syrečky","Oltermanni","Orava","Orda","Oscypek","Otlu (Van)","Ovčia hrudka","Oázis","Oštiepok","Paneer","Pannónia","Panquehue","Parenica","Passendale cheese","Passendale, Belgium","Paški sir","Pepper jack cheese","Picón Bejes-Tresviso","Pinconning cheese","Provel cheese","Province of Ávila","Przeworski","Prästost","Pule cheese","Pultost","Pálpusztai","Queijo Canastra","Queijo Cobocó","Queijo Manteiga","Queijo Meia Cura","Queijo coalho","Queijo de Colônia","Queijo de Nisa","Queijo do Pico","Queijo do Serro","Queijo prato","Queijo seco","Queijo-do-Reino","Quesillo","Queso Campesino","Queso Crema","Queso Cuajada","Queso Fresco","Queso Llanero","Queso Paipa","Queso Palmita","Queso Panela","Queso blanco","Queso crineja","Queso de cuajo","Queso de mano","Queso semiduro","Queso telita","Questo Costeño","Raclette","Radamer","Raejuusto","Rauchkäse","Red Hawk","Redykołka","Reggianito","Remoudou","Renaico","Requeijão","Rice cheese","Rodoric","Rokpol","Romadur","Roncal cheese","Roumy cheese","Rubing","Rushan","Saaremaa","Safed","Saga","Sakura cheese","Saloio","Samsø","Samsø cheese","Santarém cheese","Santorini","Sardo","Sbrinz","Schabziger","Serra da Estrela","Shanklish","Sirene","Smetankowyi","Smoked cheese","Snøfrisk","So (dairy product)","Southern Ostrobothnia, Kainuu","Soy cheese","String cheese","Stånga","Sulguni","Surti Paneer","Svecia","Swiss cheese","Syr","Syrian cheese","São Jorge","Słupski chłopczyk","Tandil","Teleme cheese","Telemea","Tetilla cheese","Tilsit cheese","Tilsiter","Tolmin","Tolminc cheese","Torta del Casar","Tounjski","Trappista cheese","Travnik, Bosnia and Herzegovina","Travnički (Vlašić) cheese","Tulum","Tupí","Tvaroh","Tvorog (творог)","Twaróg","Tybo","Tylżycki","Tyrolean grey (Tiroler Graukäse)","Tyrozouli","Tzfat cheese","Tête de Moine","Ukraїnskyi","Urda","Urdă","Urdǎ","Vacherin Fribourgeois","Vacherin Mont d\\'Or","Valdeón cheese","Vesterhavsost","Vurda","Västerbottensost","Wagasi","Weisslacker","Wisconsin","Xynomizithra","Xynotyro","Zamojski","Zamora","Zamorano cheese","Zgorzelecki","Ädelost","Ġbejna","Łowicki","Škripavac"]
     */

    private String name;
    private List<String> item;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getItem() {
        return item;
    }

    public void setItem(List<String> item) {
        this.item = item;
    }
}