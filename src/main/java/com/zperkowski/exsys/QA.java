package com.zperkowski.exsys;

import java.util.ArrayList;
import java.util.List;

public class QA {
    public static final String q_hoay = "How old are you?";
    public static final String q_dyhutlomaav = "Do you have unlimited time, lots of money and a van?";
    public static final String q_dycythsma = "Do you consider yourself to have some musical ability?";
    public static final String q_ayptpialofpt = "Are you prepared to put in a lot of practice time?";
    public static final String q_dyhnaaulos = "Do you have nerves and an upper lip of steel?";
    public static final String q_dywtdyfm = "Do you want to drive your family mad?";
    public static final String q_fyaac = "Fancy yourself as a composer?";
    public static final String q_aymmomm = "Are you more Mozart or more McCartney?";
    public static final String q_dywtbcoa = "Do you want to be center of attention?";
    public static final String q_dyfabojots = "Do you fancy a bit of jazz on the side?";
    public static final String q_dyhabh = "Do you have a big house?";
    public static final String q_dyhyn = "Do you hate your neighbours?";
    public static final String q_dywtpiao = "Do you want to play in a orchestra?";
    public static final String q_dylfm = "Do you like folk music?";
    public static final String q_dyelhw = "Do you enjoy lifting heavy weights?";
    public static final String q_dyhagsorat = "Do you have a good sense of rhythm and timing?";
    public static final String q_dyhaatsoc = "Do you have an aversion to spit or condensation?";
    public static final String q_dymbtbopj = "Do you mind being the butt of people's jokes?";
    public static final String q_dywac = "Do you want a challenge?";
    public static final String q_dymfar = "Do you mind fiddling about reeds?";
    public static final String q_labosae = "Loud and bold or soft and elegant?";
    public static final String q_dywtsos = "Do you wish to sit or stand?";
    public static final String q_dywtmia8cb = "Do you want to moonlight in an 8os cover band?";

    public static final String a_05 = "0-5 years old";
    public static final String a_612 = "6-12 years old";
    public static final String a_13 = "13+ years old";
    public static final String a_yihagac = "Yes! I've also got a chauffeur";
    public static final String a_nr = "Not really";
    public static final String a_yiaa = "Yes, I'm amazing";
    public static final String a_y = "Yes!";
    public static final String a_niahjtp = "No, I'm happy just to play";
    public static final String a_nat = "Not an total (?)";
    public static final String a_nijwtgpaqap = "No, I just want to get playing as quickly as possible";
    public static final String a_ihs = "I have some";
    public static final String a_nq = "Not quite";
    public static final String a_tsjlm = "That sounds just like me";
    public static final String a_wnij = "Wouldn't I just";
    public static final String a_ianab = "I'm not a bart!";
    public static final String a_np = "Not particularly";
    public static final String a_m = "Motzart";
    public static final String a_mc = "McCartney";
    public static final String a_yiagbas = "Yes, I'm gonna be a star";
    public static final String a_jinmiin = "Jazz isn't music it's noise";
    public static final String a_stc = "Sure thing, cat!";
    public static final String a_mriaatp = "Not really, I'm a team player";
    public static final String a_iliac = "I live in a church";
    public static final String a_tipor = "There's plenty of room";
    public static final String a_iimcab = "It's more compact and bijou";
    public static final String a_tmptmn = "To many people, too much noise";
    public static final String a_wap = "With a passion";
    public static final String a_iawfimh = "I always wear flower in my hair";
    public static final String a_ntaqn = "No, they're quite nice";
    public static final String a_iaomos = "I'm often mistaken for Superman";
    public static final String a_mlislas = "My life is like a symphony!";
    public static final String a_ianah = "I'm not a hippy";
    public static final String a_ianawb = "I'm not a wing(?), but...";
    public static final String a_yipsd = "Yuck, I prefer staying dry";
    public static final String a_ofiib = "Osly if it's baroque";
    public static final String a_iioig = "It's ok I guess";
    public static final String a_iaahm = "I'm a human metronome";
    public static final String a_mah = "Music above hygiene";
    public static final String a_lits = "Life's too short";
    public static final String a_biogmarc = "Bring it on, give me a real challenge!";
    public static final String a_ilac = "I like a challenge";
    public static final String a_niats = "No, I'm terribly sensitive";
    public static final String a_ilagl = "I love a good laugh";
    public static final String a_tslwtmh = "That sounds like way too much hassle";
    public static final String a_ilfmt = "I love frustrating manual tasks";
    public static final String a_l = "Louder!";
    public static final String a_ep = "Elegant, please";
    public static final String a_iigmos = "If I get my own solo";
    public static final String a_dn = "Definitely not";
    public static final String a_sit = "Sitteth";
    public static final String a_stand = "Standeth";

    private String question;
    private List<String> answers;
    private String answerd;

    public QA() {
        question = "";
        (answers = new ArrayList<>()).add("");
        answerd = "";
    }

    public QA(String question, List<String> answers) {
        this.question = question;
        this.answers = answers;
        this.answerd = "";
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getAnswerd() {
        return answerd;
    }

    public void setAnswerd(String answerd) {
        this.answerd = answerd;
    }
}
