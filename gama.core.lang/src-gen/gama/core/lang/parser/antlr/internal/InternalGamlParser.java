package gama.core.lang.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import gama.core.lang.services.GamlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalGamlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INTEGER", "RULE_DOUBLE", "RULE_BOOLEAN", "RULE_KEYWORD", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'__synthetic__'", "'<-'", "'model'", "'import'", "'as'", "'@'", "'model:'", "';'", "'global'", "'loop'", "'if'", "'else'", "'try'", "'catch'", "'return'", "'when'", "':'", "'('", "')'", "'action'", "'{'", "'}'", "'='", "'display'", "'equation'", "'solve'", "'species'", "'grid'", "'experiment'", "'ask'", "'release'", "'capture'", "'create'", "'write'", "'error'", "'warn'", "'exception'", "'save'", "'assert'", "'inspect'", "'browse'", "'draw'", "'using'", "'switch'", "'put'", "'add'", "'remove'", "'match'", "'match_between'", "'match_one'", "'parameter'", "'status'", "'highlight'", "'focus_on'", "'layout'", "'light'", "'camera'", "'text'", "'image'", "'data'", "'chart'", "'agents'", "'graphics'", "'display_population'", "'display_grid'", "'quadtree'", "'event'", "'overlay'", "'datalist'", "'do'", "'invoke'", "'init'", "'reflex'", "'aspect'", "'<<'", "'>'", "'<<+'", "'>-'", "'+<-'", "'<+'", "','", "'name:'", "'returns:'", "'as:'", "'of:'", "'parent:'", "'species:'", "'type:'", "'data:'", "'value:'", "'topology:'", "'item:'", "'init:'", "'message:'", "'control:'", "'layout:'", "'environment:'", "'text:'", "'image:'", "'using:'", "'parameter:'", "'aspect:'", "'light:'", "'action:'", "'on_change:'", "'->'", "'::'", "'?'", "'or'", "'and'", "'!='", "'>='", "'<='", "'<'", "'+'", "'-'", "'*'", "'/'", "'^'", "'#'", "'!'", "'my'", "'the'", "'not'", "'['", "']'", "'.'", "'**unit*'", "'**type*'", "'**action*'", "'**skill*'", "'**var*'", "'**equation*'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int T__50=50;
    public static final int T__145=145;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__139=139;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_KEYWORD=9;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_BOOLEAN=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=11;
    public static final int RULE_DOUBLE=7;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=12;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int RULE_INTEGER=6;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalGamlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGamlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGamlParser.tokenNames; }
    public String getGrammarFileName() { return "InternalGaml.g"; }



     	private GamlGrammarAccess grammarAccess;

        public InternalGamlParser(TokenStream input, GamlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Entry";
       	}

       	@Override
       	protected GamlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleEntry"
    // InternalGaml.g:64:1: entryRuleEntry returns [EObject current=null] : iv_ruleEntry= ruleEntry EOF ;
    public final EObject entryRuleEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntry = null;


        try {
            // InternalGaml.g:64:46: (iv_ruleEntry= ruleEntry EOF )
            // InternalGaml.g:65:2: iv_ruleEntry= ruleEntry EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEntryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEntry=ruleEntry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEntry; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // InternalGaml.g:71:1: ruleEntry returns [EObject current=null] : ( ( ( '@' | 'model' )=>this_Model_0= ruleModel ) | this_StringEvaluator_1= ruleStringEvaluator | this_StandaloneBlock_2= ruleStandaloneBlock | this_ExperimentFileStructure_3= ruleExperimentFileStructure ) ;
    public final EObject ruleEntry() throws RecognitionException {
        EObject current = null;

        EObject this_Model_0 = null;

        EObject this_StringEvaluator_1 = null;

        EObject this_StandaloneBlock_2 = null;

        EObject this_ExperimentFileStructure_3 = null;



        	enterRule();

        try {
            // InternalGaml.g:77:2: ( ( ( ( '@' | 'model' )=>this_Model_0= ruleModel ) | this_StringEvaluator_1= ruleStringEvaluator | this_StandaloneBlock_2= ruleStandaloneBlock | this_ExperimentFileStructure_3= ruleExperimentFileStructure ) )
            // InternalGaml.g:78:2: ( ( ( '@' | 'model' )=>this_Model_0= ruleModel ) | this_StringEvaluator_1= ruleStringEvaluator | this_StandaloneBlock_2= ruleStandaloneBlock | this_ExperimentFileStructure_3= ruleExperimentFileStructure )
            {
            // InternalGaml.g:78:2: ( ( ( '@' | 'model' )=>this_Model_0= ruleModel ) | this_StringEvaluator_1= ruleStringEvaluator | this_StandaloneBlock_2= ruleStandaloneBlock | this_ExperimentFileStructure_3= ruleExperimentFileStructure )
            int alt1=4;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==19) && (synpred1_InternalGaml())) {
                alt1=1;
            }
            else if ( (LA1_0==16) && (synpred1_InternalGaml())) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID) ) {
                alt1=2;
            }
            else if ( (LA1_0==14) ) {
                alt1=3;
            }
            else if ( (LA1_0==42) ) {
                alt1=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalGaml.g:79:3: ( ( '@' | 'model' )=>this_Model_0= ruleModel )
                    {
                    // InternalGaml.g:79:3: ( ( '@' | 'model' )=>this_Model_0= ruleModel )
                    // InternalGaml.g:80:4: ( '@' | 'model' )=>this_Model_0= ruleModel
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getEntryAccess().getModelParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_Model_0=ruleModel();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Model_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:91:3: this_StringEvaluator_1= ruleStringEvaluator
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEntryAccess().getStringEvaluatorParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringEvaluator_1=ruleStringEvaluator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringEvaluator_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGaml.g:100:3: this_StandaloneBlock_2= ruleStandaloneBlock
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEntryAccess().getStandaloneBlockParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StandaloneBlock_2=ruleStandaloneBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StandaloneBlock_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalGaml.g:109:3: this_ExperimentFileStructure_3= ruleExperimentFileStructure
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEntryAccess().getExperimentFileStructureParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExperimentFileStructure_3=ruleExperimentFileStructure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExperimentFileStructure_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntry"


    // $ANTLR start "entryRuleStandaloneBlock"
    // InternalGaml.g:121:1: entryRuleStandaloneBlock returns [EObject current=null] : iv_ruleStandaloneBlock= ruleStandaloneBlock EOF ;
    public final EObject entryRuleStandaloneBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStandaloneBlock = null;


        try {
            // InternalGaml.g:121:56: (iv_ruleStandaloneBlock= ruleStandaloneBlock EOF )
            // InternalGaml.g:122:2: iv_ruleStandaloneBlock= ruleStandaloneBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStandaloneBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStandaloneBlock=ruleStandaloneBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStandaloneBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStandaloneBlock"


    // $ANTLR start "ruleStandaloneBlock"
    // InternalGaml.g:128:1: ruleStandaloneBlock returns [EObject current=null] : (otherlv_0= '__synthetic__' ( (lv_block_1_0= ruleBlock ) ) ) ;
    public final EObject ruleStandaloneBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_block_1_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:134:2: ( (otherlv_0= '__synthetic__' ( (lv_block_1_0= ruleBlock ) ) ) )
            // InternalGaml.g:135:2: (otherlv_0= '__synthetic__' ( (lv_block_1_0= ruleBlock ) ) )
            {
            // InternalGaml.g:135:2: (otherlv_0= '__synthetic__' ( (lv_block_1_0= ruleBlock ) ) )
            // InternalGaml.g:136:3: otherlv_0= '__synthetic__' ( (lv_block_1_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStandaloneBlockAccess().get__synthetic__Keyword_0());
              		
            }
            // InternalGaml.g:140:3: ( (lv_block_1_0= ruleBlock ) )
            // InternalGaml.g:141:4: (lv_block_1_0= ruleBlock )
            {
            // InternalGaml.g:141:4: (lv_block_1_0= ruleBlock )
            // InternalGaml.g:142:5: lv_block_1_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStandaloneBlockAccess().getBlockBlockParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_block_1_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getStandaloneBlockRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_1_0,
              						"gama.core.lang.Gaml.Block");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStandaloneBlock"


    // $ANTLR start "entryRuleStringEvaluator"
    // InternalGaml.g:163:1: entryRuleStringEvaluator returns [EObject current=null] : iv_ruleStringEvaluator= ruleStringEvaluator EOF ;
    public final EObject entryRuleStringEvaluator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringEvaluator = null;


        try {
            // InternalGaml.g:163:56: (iv_ruleStringEvaluator= ruleStringEvaluator EOF )
            // InternalGaml.g:164:2: iv_ruleStringEvaluator= ruleStringEvaluator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringEvaluatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringEvaluator=ruleStringEvaluator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringEvaluator; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringEvaluator"


    // $ANTLR start "ruleStringEvaluator"
    // InternalGaml.g:170:1: ruleStringEvaluator returns [EObject current=null] : ( ( (lv_toto_0_0= RULE_ID ) ) otherlv_1= '<-' ( (lv_expr_2_0= ruleExpression ) ) ) ;
    public final EObject ruleStringEvaluator() throws RecognitionException {
        EObject current = null;

        Token lv_toto_0_0=null;
        Token otherlv_1=null;
        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:176:2: ( ( ( (lv_toto_0_0= RULE_ID ) ) otherlv_1= '<-' ( (lv_expr_2_0= ruleExpression ) ) ) )
            // InternalGaml.g:177:2: ( ( (lv_toto_0_0= RULE_ID ) ) otherlv_1= '<-' ( (lv_expr_2_0= ruleExpression ) ) )
            {
            // InternalGaml.g:177:2: ( ( (lv_toto_0_0= RULE_ID ) ) otherlv_1= '<-' ( (lv_expr_2_0= ruleExpression ) ) )
            // InternalGaml.g:178:3: ( (lv_toto_0_0= RULE_ID ) ) otherlv_1= '<-' ( (lv_expr_2_0= ruleExpression ) )
            {
            // InternalGaml.g:178:3: ( (lv_toto_0_0= RULE_ID ) )
            // InternalGaml.g:179:4: (lv_toto_0_0= RULE_ID )
            {
            // InternalGaml.g:179:4: (lv_toto_0_0= RULE_ID )
            // InternalGaml.g:180:5: lv_toto_0_0= RULE_ID
            {
            lv_toto_0_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_toto_0_0, grammarAccess.getStringEvaluatorAccess().getTotoIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStringEvaluatorRule());
              					}
              					setWithLastConsumed(
              						current,
              						"toto",
              						lv_toto_0_0,
              						"gama.core.lang.Gaml.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStringEvaluatorAccess().getLessThanSignHyphenMinusKeyword_1());
              		
            }
            // InternalGaml.g:200:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalGaml.g:201:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalGaml.g:201:4: (lv_expr_2_0= ruleExpression )
            // InternalGaml.g:202:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStringEvaluatorAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getStringEvaluatorRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"gama.core.lang.Gaml.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringEvaluator"


    // $ANTLR start "entryRuleModel"
    // InternalGaml.g:223:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalGaml.g:223:46: (iv_ruleModel= ruleModel EOF )
            // InternalGaml.g:224:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalGaml.g:230:1: ruleModel returns [EObject current=null] : ( ( (lv_pragmas_0_0= rulePragma ) )* otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_block_4_0= ruleModelBlock ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_pragmas_0_0 = null;

        EObject lv_imports_3_0 = null;

        EObject lv_block_4_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:236:2: ( ( ( (lv_pragmas_0_0= rulePragma ) )* otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_block_4_0= ruleModelBlock ) ) ) )
            // InternalGaml.g:237:2: ( ( (lv_pragmas_0_0= rulePragma ) )* otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_block_4_0= ruleModelBlock ) ) )
            {
            // InternalGaml.g:237:2: ( ( (lv_pragmas_0_0= rulePragma ) )* otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_block_4_0= ruleModelBlock ) ) )
            // InternalGaml.g:238:3: ( (lv_pragmas_0_0= rulePragma ) )* otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_block_4_0= ruleModelBlock ) )
            {
            // InternalGaml.g:238:3: ( (lv_pragmas_0_0= rulePragma ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalGaml.g:239:4: (lv_pragmas_0_0= rulePragma )
            	    {
            	    // InternalGaml.g:239:4: (lv_pragmas_0_0= rulePragma )
            	    // InternalGaml.g:240:5: lv_pragmas_0_0= rulePragma
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getModelAccess().getPragmasPragmaParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_pragmas_0_0=rulePragma();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getModelRule());
            	      					}
            	      					add(
            	      						current,
            	      						"pragmas",
            	      						lv_pragmas_0_0,
            	      						"gama.core.lang.Gaml.Pragma");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_1=(Token)match(input,16,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getModelAccess().getModelKeyword_1());
              		
            }
            // InternalGaml.g:261:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalGaml.g:262:4: (lv_name_2_0= RULE_ID )
            {
            // InternalGaml.g:262:4: (lv_name_2_0= RULE_ID )
            // InternalGaml.g:263:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getModelRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"gama.core.lang.Gaml.ID");
              				
            }

            }


            }

            // InternalGaml.g:279:3: ( (lv_imports_3_0= ruleImport ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalGaml.g:280:4: (lv_imports_3_0= ruleImport )
            	    {
            	    // InternalGaml.g:280:4: (lv_imports_3_0= ruleImport )
            	    // InternalGaml.g:281:5: lv_imports_3_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getModelRule());
            	      					}
            	      					add(
            	      						current,
            	      						"imports",
            	      						lv_imports_3_0,
            	      						"gama.core.lang.Gaml.Import");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalGaml.g:298:3: ( (lv_block_4_0= ruleModelBlock ) )
            // InternalGaml.g:299:4: (lv_block_4_0= ruleModelBlock )
            {
            // InternalGaml.g:299:4: (lv_block_4_0= ruleModelBlock )
            // InternalGaml.g:300:5: lv_block_4_0= ruleModelBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getModelAccess().getBlockModelBlockParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_block_4_0=ruleModelBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getModelRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_4_0,
              						"gama.core.lang.Gaml.ModelBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleModelBlock"
    // InternalGaml.g:321:1: entryRuleModelBlock returns [EObject current=null] : iv_ruleModelBlock= ruleModelBlock EOF ;
    public final EObject entryRuleModelBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelBlock = null;


        try {
            // InternalGaml.g:321:51: (iv_ruleModelBlock= ruleModelBlock EOF )
            // InternalGaml.g:322:2: iv_ruleModelBlock= ruleModelBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModelBlock=ruleModelBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModelBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelBlock"


    // $ANTLR start "ruleModelBlock"
    // InternalGaml.g:328:1: ruleModelBlock returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleS_Section ) )* ) ;
    public final EObject ruleModelBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:334:2: ( ( () ( (lv_statements_1_0= ruleS_Section ) )* ) )
            // InternalGaml.g:335:2: ( () ( (lv_statements_1_0= ruleS_Section ) )* )
            {
            // InternalGaml.g:335:2: ( () ( (lv_statements_1_0= ruleS_Section ) )* )
            // InternalGaml.g:336:3: () ( (lv_statements_1_0= ruleS_Section ) )*
            {
            // InternalGaml.g:336:3: ()
            // InternalGaml.g:337:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getModelBlockAccess().getBlockAction_0(),
              					current);
              			
            }

            }

            // InternalGaml.g:343:3: ( (lv_statements_1_0= ruleS_Section ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==22||(LA4_0>=40 && LA4_0<=42)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalGaml.g:344:4: (lv_statements_1_0= ruleS_Section )
            	    {
            	    // InternalGaml.g:344:4: (lv_statements_1_0= ruleS_Section )
            	    // InternalGaml.g:345:5: lv_statements_1_0= ruleS_Section
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getModelBlockAccess().getStatementsS_SectionParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_statements_1_0=ruleS_Section();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getModelBlockRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_1_0,
            	      						"gama.core.lang.Gaml.S_Section");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelBlock"


    // $ANTLR start "entryRuleImport"
    // InternalGaml.g:366:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalGaml.g:366:47: (iv_ruleImport= ruleImport EOF )
            // InternalGaml.g:367:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalGaml.g:373:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_name_3_0= ruleValid_ID ) ) )? ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:379:2: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_name_3_0= ruleValid_ID ) ) )? ) )
            // InternalGaml.g:380:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_name_3_0= ruleValid_ID ) ) )? )
            {
            // InternalGaml.g:380:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_name_3_0= ruleValid_ID ) ) )? )
            // InternalGaml.g:381:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_name_3_0= ruleValid_ID ) ) )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
              		
            }
            // InternalGaml.g:385:3: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalGaml.g:386:4: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalGaml.g:386:4: (lv_importURI_1_0= RULE_STRING )
            // InternalGaml.g:387:5: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportRule());
              					}
              					setWithLastConsumed(
              						current,
              						"importURI",
              						lv_importURI_1_0,
              						"gama.core.lang.Gaml.STRING");
              				
            }

            }


            }

            // InternalGaml.g:403:3: (otherlv_2= 'as' ( (lv_name_3_0= ruleValid_ID ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalGaml.g:404:4: otherlv_2= 'as' ( (lv_name_3_0= ruleValid_ID ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getImportAccess().getAsKeyword_2_0());
                      			
                    }
                    // InternalGaml.g:408:4: ( (lv_name_3_0= ruleValid_ID ) )
                    // InternalGaml.g:409:5: (lv_name_3_0= ruleValid_ID )
                    {
                    // InternalGaml.g:409:5: (lv_name_3_0= ruleValid_ID )
                    // InternalGaml.g:410:6: lv_name_3_0= ruleValid_ID
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getImportAccess().getNameValid_IDParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_name_3_0=ruleValid_ID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getImportRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_3_0,
                      							"gama.core.lang.Gaml.Valid_ID");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRulePragma"
    // InternalGaml.g:432:1: entryRulePragma returns [EObject current=null] : iv_rulePragma= rulePragma EOF ;
    public final EObject entryRulePragma() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragma = null;


        try {
            // InternalGaml.g:432:47: (iv_rulePragma= rulePragma EOF )
            // InternalGaml.g:433:2: iv_rulePragma= rulePragma EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPragmaRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePragma=rulePragma();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePragma; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePragma"


    // $ANTLR start "rulePragma"
    // InternalGaml.g:439:1: rulePragma returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePragma() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalGaml.g:445:2: ( (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalGaml.g:446:2: (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalGaml.g:446:2: (otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalGaml.g:447:3: otherlv_0= '@' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPragmaAccess().getCommercialAtKeyword_0());
              		
            }
            // InternalGaml.g:451:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGaml.g:452:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGaml.g:452:4: (lv_name_1_0= RULE_ID )
            // InternalGaml.g:453:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getPragmaAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPragmaRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"gama.core.lang.Gaml.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePragma"


    // $ANTLR start "entryRuleExperimentFileStructure"
    // InternalGaml.g:473:1: entryRuleExperimentFileStructure returns [EObject current=null] : iv_ruleExperimentFileStructure= ruleExperimentFileStructure EOF ;
    public final EObject entryRuleExperimentFileStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExperimentFileStructure = null;


        try {
            // InternalGaml.g:473:64: (iv_ruleExperimentFileStructure= ruleExperimentFileStructure EOF )
            // InternalGaml.g:474:2: iv_ruleExperimentFileStructure= ruleExperimentFileStructure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExperimentFileStructureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExperimentFileStructure=ruleExperimentFileStructure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExperimentFileStructure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExperimentFileStructure"


    // $ANTLR start "ruleExperimentFileStructure"
    // InternalGaml.g:480:1: ruleExperimentFileStructure returns [EObject current=null] : ( (lv_exp_0_0= ruleHeadlessExperiment ) ) ;
    public final EObject ruleExperimentFileStructure() throws RecognitionException {
        EObject current = null;

        EObject lv_exp_0_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:486:2: ( ( (lv_exp_0_0= ruleHeadlessExperiment ) ) )
            // InternalGaml.g:487:2: ( (lv_exp_0_0= ruleHeadlessExperiment ) )
            {
            // InternalGaml.g:487:2: ( (lv_exp_0_0= ruleHeadlessExperiment ) )
            // InternalGaml.g:488:3: (lv_exp_0_0= ruleHeadlessExperiment )
            {
            // InternalGaml.g:488:3: (lv_exp_0_0= ruleHeadlessExperiment )
            // InternalGaml.g:489:4: lv_exp_0_0= ruleHeadlessExperiment
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getExperimentFileStructureAccess().getExpHeadlessExperimentParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_exp_0_0=ruleHeadlessExperiment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getExperimentFileStructureRule());
              				}
              				set(
              					current,
              					"exp",
              					lv_exp_0_0,
              					"gama.core.lang.Gaml.HeadlessExperiment");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExperimentFileStructure"


    // $ANTLR start "entryRuleHeadlessExperiment"
    // InternalGaml.g:509:1: entryRuleHeadlessExperiment returns [EObject current=null] : iv_ruleHeadlessExperiment= ruleHeadlessExperiment EOF ;
    public final EObject entryRuleHeadlessExperiment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeadlessExperiment = null;


        try {
            // InternalGaml.g:509:59: (iv_ruleHeadlessExperiment= ruleHeadlessExperiment EOF )
            // InternalGaml.g:510:2: iv_ruleHeadlessExperiment= ruleHeadlessExperiment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHeadlessExperimentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHeadlessExperiment=ruleHeadlessExperiment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHeadlessExperiment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHeadlessExperiment"


    // $ANTLR start "ruleHeadlessExperiment"
    // InternalGaml.g:516:1: ruleHeadlessExperiment returns [EObject current=null] : ( ( (lv_key_0_0= rule_ExperimentKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) (otherlv_2= 'model:' ( (lv_importURI_3_0= RULE_STRING ) ) )? ( (lv_facets_4_0= ruleFacet ) )* ( ( (lv_block_5_0= ruleBlock ) ) | otherlv_6= ';' ) ) ;
    public final EObject ruleHeadlessExperiment() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_2=null;
        Token otherlv_2=null;
        Token lv_importURI_3_0=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_1 = null;

        EObject lv_facets_4_0 = null;

        EObject lv_block_5_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:522:2: ( ( ( (lv_key_0_0= rule_ExperimentKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) (otherlv_2= 'model:' ( (lv_importURI_3_0= RULE_STRING ) ) )? ( (lv_facets_4_0= ruleFacet ) )* ( ( (lv_block_5_0= ruleBlock ) ) | otherlv_6= ';' ) ) )
            // InternalGaml.g:523:2: ( ( (lv_key_0_0= rule_ExperimentKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) (otherlv_2= 'model:' ( (lv_importURI_3_0= RULE_STRING ) ) )? ( (lv_facets_4_0= ruleFacet ) )* ( ( (lv_block_5_0= ruleBlock ) ) | otherlv_6= ';' ) )
            {
            // InternalGaml.g:523:2: ( ( (lv_key_0_0= rule_ExperimentKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) (otherlv_2= 'model:' ( (lv_importURI_3_0= RULE_STRING ) ) )? ( (lv_facets_4_0= ruleFacet ) )* ( ( (lv_block_5_0= ruleBlock ) ) | otherlv_6= ';' ) )
            // InternalGaml.g:524:3: ( (lv_key_0_0= rule_ExperimentKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) (otherlv_2= 'model:' ( (lv_importURI_3_0= RULE_STRING ) ) )? ( (lv_facets_4_0= ruleFacet ) )* ( ( (lv_block_5_0= ruleBlock ) ) | otherlv_6= ';' )
            {
            // InternalGaml.g:524:3: ( (lv_key_0_0= rule_ExperimentKey ) )
            // InternalGaml.g:525:4: (lv_key_0_0= rule_ExperimentKey )
            {
            // InternalGaml.g:525:4: (lv_key_0_0= rule_ExperimentKey )
            // InternalGaml.g:526:5: lv_key_0_0= rule_ExperimentKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHeadlessExperimentAccess().getKey_ExperimentKeyParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_key_0_0=rule_ExperimentKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHeadlessExperimentRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_0_0,
              						"gama.core.lang.Gaml._ExperimentKey");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:543:3: ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) )
            // InternalGaml.g:544:4: ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) )
            {
            // InternalGaml.g:544:4: ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) )
            // InternalGaml.g:545:5: (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING )
            {
            // InternalGaml.g:545:5: (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID||LA6_0==38||(LA6_0>=40 && LA6_0<=87)) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_STRING) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalGaml.g:546:6: lv_name_1_1= ruleValid_ID
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getHeadlessExperimentAccess().getNameValid_IDParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_14);
                    lv_name_1_1=ruleValid_ID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getHeadlessExperimentRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_1_1,
                      							"gama.core.lang.Gaml.Valid_ID");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:562:6: lv_name_1_2= RULE_STRING
                    {
                    lv_name_1_2=(Token)match(input,RULE_STRING,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_2, grammarAccess.getHeadlessExperimentAccess().getNameSTRINGTerminalRuleCall_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getHeadlessExperimentRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_1_2,
                      							"gama.core.lang.Gaml.STRING");
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalGaml.g:579:3: (otherlv_2= 'model:' ( (lv_importURI_3_0= RULE_STRING ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalGaml.g:580:4: otherlv_2= 'model:' ( (lv_importURI_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getHeadlessExperimentAccess().getModelKeyword_2_0());
                      			
                    }
                    // InternalGaml.g:584:4: ( (lv_importURI_3_0= RULE_STRING ) )
                    // InternalGaml.g:585:5: (lv_importURI_3_0= RULE_STRING )
                    {
                    // InternalGaml.g:585:5: (lv_importURI_3_0= RULE_STRING )
                    // InternalGaml.g:586:6: lv_importURI_3_0= RULE_STRING
                    {
                    lv_importURI_3_0=(Token)match(input,RULE_STRING,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_importURI_3_0, grammarAccess.getHeadlessExperimentAccess().getImportURISTRINGTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getHeadlessExperimentRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"importURI",
                      							lv_importURI_3_0,
                      							"gama.core.lang.Gaml.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalGaml.g:603:3: ( (lv_facets_4_0= ruleFacet ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==15||LA8_0==29||(LA8_0>=95 && LA8_0<=119)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalGaml.g:604:4: (lv_facets_4_0= ruleFacet )
            	    {
            	    // InternalGaml.g:604:4: (lv_facets_4_0= ruleFacet )
            	    // InternalGaml.g:605:5: lv_facets_4_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getHeadlessExperimentAccess().getFacetsFacetParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_facets_4_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getHeadlessExperimentRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_4_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalGaml.g:622:3: ( ( (lv_block_5_0= ruleBlock ) ) | otherlv_6= ';' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==34) ) {
                alt9=1;
            }
            else if ( (LA9_0==21) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalGaml.g:623:4: ( (lv_block_5_0= ruleBlock ) )
                    {
                    // InternalGaml.g:623:4: ( (lv_block_5_0= ruleBlock ) )
                    // InternalGaml.g:624:5: (lv_block_5_0= ruleBlock )
                    {
                    // InternalGaml.g:624:5: (lv_block_5_0= ruleBlock )
                    // InternalGaml.g:625:6: lv_block_5_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getHeadlessExperimentAccess().getBlockBlockParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_5_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getHeadlessExperimentRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_5_0,
                      							"gama.core.lang.Gaml.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:643:4: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getHeadlessExperimentAccess().getSemicolonKeyword_4_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHeadlessExperiment"


    // $ANTLR start "entryRuleS_Section"
    // InternalGaml.g:652:1: entryRuleS_Section returns [EObject current=null] : iv_ruleS_Section= ruleS_Section EOF ;
    public final EObject entryRuleS_Section() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Section = null;


        try {
            // InternalGaml.g:652:50: (iv_ruleS_Section= ruleS_Section EOF )
            // InternalGaml.g:653:2: iv_ruleS_Section= ruleS_Section EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_SectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Section=ruleS_Section();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Section; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Section"


    // $ANTLR start "ruleS_Section"
    // InternalGaml.g:659:1: ruleS_Section returns [EObject current=null] : (this_S_Global_0= ruleS_Global | this_S_Species_1= ruleS_Species | this_S_Experiment_2= ruleS_Experiment ) ;
    public final EObject ruleS_Section() throws RecognitionException {
        EObject current = null;

        EObject this_S_Global_0 = null;

        EObject this_S_Species_1 = null;

        EObject this_S_Experiment_2 = null;



        	enterRule();

        try {
            // InternalGaml.g:665:2: ( (this_S_Global_0= ruleS_Global | this_S_Species_1= ruleS_Species | this_S_Experiment_2= ruleS_Experiment ) )
            // InternalGaml.g:666:2: (this_S_Global_0= ruleS_Global | this_S_Species_1= ruleS_Species | this_S_Experiment_2= ruleS_Experiment )
            {
            // InternalGaml.g:666:2: (this_S_Global_0= ruleS_Global | this_S_Species_1= ruleS_Species | this_S_Experiment_2= ruleS_Experiment )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt10=1;
                }
                break;
            case 40:
            case 41:
                {
                alt10=2;
                }
                break;
            case 42:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalGaml.g:667:3: this_S_Global_0= ruleS_Global
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getS_SectionAccess().getS_GlobalParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Global_0=ruleS_Global();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_S_Global_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:676:3: this_S_Species_1= ruleS_Species
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getS_SectionAccess().getS_SpeciesParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Species_1=ruleS_Species();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_S_Species_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGaml.g:685:3: this_S_Experiment_2= ruleS_Experiment
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getS_SectionAccess().getS_ExperimentParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Experiment_2=ruleS_Experiment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_S_Experiment_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Section"


    // $ANTLR start "entryRuleS_Global"
    // InternalGaml.g:697:1: entryRuleS_Global returns [EObject current=null] : iv_ruleS_Global= ruleS_Global EOF ;
    public final EObject entryRuleS_Global() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Global = null;


        try {
            // InternalGaml.g:697:49: (iv_ruleS_Global= ruleS_Global EOF )
            // InternalGaml.g:698:2: iv_ruleS_Global= ruleS_Global EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_GlobalRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Global=ruleS_Global();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Global; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Global"


    // $ANTLR start "ruleS_Global"
    // InternalGaml.g:704:1: ruleS_Global returns [EObject current=null] : ( ( (lv_key_0_0= 'global' ) ) ( (lv_facets_1_0= ruleFacet ) )* ( ( (lv_block_2_0= ruleBlock ) ) | otherlv_3= ';' ) ) ;
    public final EObject ruleS_Global() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_3=null;
        EObject lv_facets_1_0 = null;

        EObject lv_block_2_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:710:2: ( ( ( (lv_key_0_0= 'global' ) ) ( (lv_facets_1_0= ruleFacet ) )* ( ( (lv_block_2_0= ruleBlock ) ) | otherlv_3= ';' ) ) )
            // InternalGaml.g:711:2: ( ( (lv_key_0_0= 'global' ) ) ( (lv_facets_1_0= ruleFacet ) )* ( ( (lv_block_2_0= ruleBlock ) ) | otherlv_3= ';' ) )
            {
            // InternalGaml.g:711:2: ( ( (lv_key_0_0= 'global' ) ) ( (lv_facets_1_0= ruleFacet ) )* ( ( (lv_block_2_0= ruleBlock ) ) | otherlv_3= ';' ) )
            // InternalGaml.g:712:3: ( (lv_key_0_0= 'global' ) ) ( (lv_facets_1_0= ruleFacet ) )* ( ( (lv_block_2_0= ruleBlock ) ) | otherlv_3= ';' )
            {
            // InternalGaml.g:712:3: ( (lv_key_0_0= 'global' ) )
            // InternalGaml.g:713:4: (lv_key_0_0= 'global' )
            {
            // InternalGaml.g:713:4: (lv_key_0_0= 'global' )
            // InternalGaml.g:714:5: lv_key_0_0= 'global'
            {
            lv_key_0_0=(Token)match(input,22,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_key_0_0, grammarAccess.getS_GlobalAccess().getKeyGlobalKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getS_GlobalRule());
              					}
              					setWithLastConsumed(current, "key", lv_key_0_0, "global");
              				
            }

            }


            }

            // InternalGaml.g:726:3: ( (lv_facets_1_0= ruleFacet ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID||LA11_0==15||LA11_0==29||(LA11_0>=95 && LA11_0<=119)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalGaml.g:727:4: (lv_facets_1_0= ruleFacet )
            	    {
            	    // InternalGaml.g:727:4: (lv_facets_1_0= ruleFacet )
            	    // InternalGaml.g:728:5: lv_facets_1_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getS_GlobalAccess().getFacetsFacetParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_facets_1_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getS_GlobalRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_1_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalGaml.g:745:3: ( ( (lv_block_2_0= ruleBlock ) ) | otherlv_3= ';' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==34) ) {
                alt12=1;
            }
            else if ( (LA12_0==21) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalGaml.g:746:4: ( (lv_block_2_0= ruleBlock ) )
                    {
                    // InternalGaml.g:746:4: ( (lv_block_2_0= ruleBlock ) )
                    // InternalGaml.g:747:5: (lv_block_2_0= ruleBlock )
                    {
                    // InternalGaml.g:747:5: (lv_block_2_0= ruleBlock )
                    // InternalGaml.g:748:6: lv_block_2_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_GlobalAccess().getBlockBlockParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_2_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_GlobalRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_2_0,
                      							"gama.core.lang.Gaml.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:766:4: otherlv_3= ';'
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getS_GlobalAccess().getSemicolonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Global"


    // $ANTLR start "entryRuleS_Species"
    // InternalGaml.g:775:1: entryRuleS_Species returns [EObject current=null] : iv_ruleS_Species= ruleS_Species EOF ;
    public final EObject entryRuleS_Species() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Species = null;


        try {
            // InternalGaml.g:775:50: (iv_ruleS_Species= ruleS_Species EOF )
            // InternalGaml.g:776:2: iv_ruleS_Species= ruleS_Species EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_SpeciesRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Species=ruleS_Species();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Species; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Species"


    // $ANTLR start "ruleS_Species"
    // InternalGaml.g:782:1: ruleS_Species returns [EObject current=null] : ( ( (lv_key_0_0= rule_SpeciesKey ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) ) ;
    public final EObject ruleS_Species() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_facets_2_0 = null;

        EObject lv_block_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:788:2: ( ( ( (lv_key_0_0= rule_SpeciesKey ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) ) )
            // InternalGaml.g:789:2: ( ( (lv_key_0_0= rule_SpeciesKey ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) )
            {
            // InternalGaml.g:789:2: ( ( (lv_key_0_0= rule_SpeciesKey ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) )
            // InternalGaml.g:790:3: ( (lv_key_0_0= rule_SpeciesKey ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' )
            {
            // InternalGaml.g:790:3: ( (lv_key_0_0= rule_SpeciesKey ) )
            // InternalGaml.g:791:4: (lv_key_0_0= rule_SpeciesKey )
            {
            // InternalGaml.g:791:4: (lv_key_0_0= rule_SpeciesKey )
            // InternalGaml.g:792:5: lv_key_0_0= rule_SpeciesKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_SpeciesAccess().getKey_SpeciesKeyParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_7);
            lv_key_0_0=rule_SpeciesKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_SpeciesRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_0_0,
              						"gama.core.lang.Gaml._SpeciesKey");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:809:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGaml.g:810:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGaml.g:810:4: (lv_name_1_0= RULE_ID )
            // InternalGaml.g:811:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getS_SpeciesAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getS_SpeciesRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"gama.core.lang.Gaml.ID");
              				
            }

            }


            }

            // InternalGaml.g:827:3: ( (lv_facets_2_0= ruleFacet ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID||LA13_0==15||LA13_0==29||(LA13_0>=95 && LA13_0<=119)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalGaml.g:828:4: (lv_facets_2_0= ruleFacet )
            	    {
            	    // InternalGaml.g:828:4: (lv_facets_2_0= ruleFacet )
            	    // InternalGaml.g:829:5: lv_facets_2_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getS_SpeciesAccess().getFacetsFacetParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_facets_2_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getS_SpeciesRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_2_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalGaml.g:846:3: ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==34) ) {
                alt14=1;
            }
            else if ( (LA14_0==21) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalGaml.g:847:4: ( (lv_block_3_0= ruleBlock ) )
                    {
                    // InternalGaml.g:847:4: ( (lv_block_3_0= ruleBlock ) )
                    // InternalGaml.g:848:5: (lv_block_3_0= ruleBlock )
                    {
                    // InternalGaml.g:848:5: (lv_block_3_0= ruleBlock )
                    // InternalGaml.g:849:6: lv_block_3_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_SpeciesAccess().getBlockBlockParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_3_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_SpeciesRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_3_0,
                      							"gama.core.lang.Gaml.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:867:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getS_SpeciesAccess().getSemicolonKeyword_3_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Species"


    // $ANTLR start "entryRuleS_Experiment"
    // InternalGaml.g:876:1: entryRuleS_Experiment returns [EObject current=null] : iv_ruleS_Experiment= ruleS_Experiment EOF ;
    public final EObject entryRuleS_Experiment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Experiment = null;


        try {
            // InternalGaml.g:876:53: (iv_ruleS_Experiment= ruleS_Experiment EOF )
            // InternalGaml.g:877:2: iv_ruleS_Experiment= ruleS_Experiment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_ExperimentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Experiment=ruleS_Experiment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Experiment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Experiment"


    // $ANTLR start "ruleS_Experiment"
    // InternalGaml.g:883:1: ruleS_Experiment returns [EObject current=null] : ( ( (lv_key_0_0= rule_ExperimentKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) ) ;
    public final EObject ruleS_Experiment() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_1 = null;

        EObject lv_facets_2_0 = null;

        EObject lv_block_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:889:2: ( ( ( (lv_key_0_0= rule_ExperimentKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) ) )
            // InternalGaml.g:890:2: ( ( (lv_key_0_0= rule_ExperimentKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) )
            {
            // InternalGaml.g:890:2: ( ( (lv_key_0_0= rule_ExperimentKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) )
            // InternalGaml.g:891:3: ( (lv_key_0_0= rule_ExperimentKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' )
            {
            // InternalGaml.g:891:3: ( (lv_key_0_0= rule_ExperimentKey ) )
            // InternalGaml.g:892:4: (lv_key_0_0= rule_ExperimentKey )
            {
            // InternalGaml.g:892:4: (lv_key_0_0= rule_ExperimentKey )
            // InternalGaml.g:893:5: lv_key_0_0= rule_ExperimentKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_ExperimentAccess().getKey_ExperimentKeyParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_key_0_0=rule_ExperimentKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_ExperimentRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_0_0,
              						"gama.core.lang.Gaml._ExperimentKey");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:910:3: ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) )
            // InternalGaml.g:911:4: ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) )
            {
            // InternalGaml.g:911:4: ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) )
            // InternalGaml.g:912:5: (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING )
            {
            // InternalGaml.g:912:5: (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID||LA15_0==38||(LA15_0>=40 && LA15_0<=87)) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_STRING) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalGaml.g:913:6: lv_name_1_1= ruleValid_ID
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_ExperimentAccess().getNameValid_IDParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
                    lv_name_1_1=ruleValid_ID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_ExperimentRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_1_1,
                      							"gama.core.lang.Gaml.Valid_ID");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:929:6: lv_name_1_2= RULE_STRING
                    {
                    lv_name_1_2=(Token)match(input,RULE_STRING,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_2, grammarAccess.getS_ExperimentAccess().getNameSTRINGTerminalRuleCall_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getS_ExperimentRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_1_2,
                      							"gama.core.lang.Gaml.STRING");
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalGaml.g:946:3: ( (lv_facets_2_0= ruleFacet ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID||LA16_0==15||LA16_0==29||(LA16_0>=95 && LA16_0<=119)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalGaml.g:947:4: (lv_facets_2_0= ruleFacet )
            	    {
            	    // InternalGaml.g:947:4: (lv_facets_2_0= ruleFacet )
            	    // InternalGaml.g:948:5: lv_facets_2_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getS_ExperimentAccess().getFacetsFacetParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_facets_2_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getS_ExperimentRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_2_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // InternalGaml.g:965:3: ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==34) ) {
                alt17=1;
            }
            else if ( (LA17_0==21) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalGaml.g:966:4: ( (lv_block_3_0= ruleBlock ) )
                    {
                    // InternalGaml.g:966:4: ( (lv_block_3_0= ruleBlock ) )
                    // InternalGaml.g:967:5: (lv_block_3_0= ruleBlock )
                    {
                    // InternalGaml.g:967:5: (lv_block_3_0= ruleBlock )
                    // InternalGaml.g:968:6: lv_block_3_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_ExperimentAccess().getBlockBlockParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_3_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_ExperimentRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_3_0,
                      							"gama.core.lang.Gaml.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:986:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getS_ExperimentAccess().getSemicolonKeyword_3_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Experiment"


    // $ANTLR start "entryRuleStatement"
    // InternalGaml.g:995:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalGaml.g:995:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalGaml.g:996:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalGaml.g:1002:1: ruleStatement returns [EObject current=null] : ( ( ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration ) | ( ( ( ruleS_Assignment )=>this_S_Assignment_1= ruleS_Assignment ) | this_S_1Expr_Facets_BlockOrEnd_2= ruleS_1Expr_Facets_BlockOrEnd | this_S_Other_3= ruleS_Other | this_S_Do_4= ruleS_Do | this_S_Return_5= ruleS_Return | this_S_Solve_6= ruleS_Solve | this_S_If_7= ruleS_If | this_S_Try_8= ruleS_Try | this_S_Equations_9= ruleS_Equations ) ) | this_S_Display_10= ruleS_Display ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_S_Declaration_0 = null;

        EObject this_S_Assignment_1 = null;

        EObject this_S_1Expr_Facets_BlockOrEnd_2 = null;

        EObject this_S_Other_3 = null;

        EObject this_S_Do_4 = null;

        EObject this_S_Return_5 = null;

        EObject this_S_Solve_6 = null;

        EObject this_S_If_7 = null;

        EObject this_S_Try_8 = null;

        EObject this_S_Equations_9 = null;

        EObject this_S_Display_10 = null;



        	enterRule();

        try {
            // InternalGaml.g:1008:2: ( ( ( ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration ) | ( ( ( ruleS_Assignment )=>this_S_Assignment_1= ruleS_Assignment ) | this_S_1Expr_Facets_BlockOrEnd_2= ruleS_1Expr_Facets_BlockOrEnd | this_S_Other_3= ruleS_Other | this_S_Do_4= ruleS_Do | this_S_Return_5= ruleS_Return | this_S_Solve_6= ruleS_Solve | this_S_If_7= ruleS_If | this_S_Try_8= ruleS_Try | this_S_Equations_9= ruleS_Equations ) ) | this_S_Display_10= ruleS_Display ) )
            // InternalGaml.g:1009:2: ( ( ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration ) | ( ( ( ruleS_Assignment )=>this_S_Assignment_1= ruleS_Assignment ) | this_S_1Expr_Facets_BlockOrEnd_2= ruleS_1Expr_Facets_BlockOrEnd | this_S_Other_3= ruleS_Other | this_S_Do_4= ruleS_Do | this_S_Return_5= ruleS_Return | this_S_Solve_6= ruleS_Solve | this_S_If_7= ruleS_If | this_S_Try_8= ruleS_Try | this_S_Equations_9= ruleS_Equations ) ) | this_S_Display_10= ruleS_Display )
            {
            // InternalGaml.g:1009:2: ( ( ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration ) | ( ( ( ruleS_Assignment )=>this_S_Assignment_1= ruleS_Assignment ) | this_S_1Expr_Facets_BlockOrEnd_2= ruleS_1Expr_Facets_BlockOrEnd | this_S_Other_3= ruleS_Other | this_S_Do_4= ruleS_Do | this_S_Return_5= ruleS_Return | this_S_Solve_6= ruleS_Solve | this_S_If_7= ruleS_If | this_S_Try_8= ruleS_Try | this_S_Equations_9= ruleS_Equations ) ) | this_S_Display_10= ruleS_Display )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_KEYWORD)||(LA20_0>=23 && LA20_0<=24)||LA20_0==26||(LA20_0>=28 && LA20_0<=29)||LA20_0==31||(LA20_0>=33 && LA20_0<=34)||(LA20_0>=38 && LA20_0<=87)||(LA20_0>=95 && LA20_0<=118)||LA20_0==129||(LA20_0>=133 && LA20_0<=138)) ) {
                alt20=1;
            }
            else if ( (LA20_0==37) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalGaml.g:1010:3: ( ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration ) | ( ( ( ruleS_Assignment )=>this_S_Assignment_1= ruleS_Assignment ) | this_S_1Expr_Facets_BlockOrEnd_2= ruleS_1Expr_Facets_BlockOrEnd | this_S_Other_3= ruleS_Other | this_S_Do_4= ruleS_Do | this_S_Return_5= ruleS_Return | this_S_Solve_6= ruleS_Solve | this_S_If_7= ruleS_If | this_S_Try_8= ruleS_Try | this_S_Equations_9= ruleS_Equations ) )
                    {
                    // InternalGaml.g:1010:3: ( ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration ) | ( ( ( ruleS_Assignment )=>this_S_Assignment_1= ruleS_Assignment ) | this_S_1Expr_Facets_BlockOrEnd_2= ruleS_1Expr_Facets_BlockOrEnd | this_S_Other_3= ruleS_Other | this_S_Do_4= ruleS_Do | this_S_Return_5= ruleS_Return | this_S_Solve_6= ruleS_Solve | this_S_If_7= ruleS_If | this_S_Try_8= ruleS_Try | this_S_Equations_9= ruleS_Equations ) )
                    int alt19=2;
                    alt19 = dfa19.predict(input);
                    switch (alt19) {
                        case 1 :
                            // InternalGaml.g:1011:4: ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration )
                            {
                            // InternalGaml.g:1011:4: ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration )
                            // InternalGaml.g:1012:5: ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration
                            {
                            if ( state.backtracking==0 ) {

                              					newCompositeNode(grammarAccess.getStatementAccess().getS_DeclarationParserRuleCall_0_0());
                              				
                            }
                            pushFollow(FOLLOW_2);
                            this_S_Declaration_0=ruleS_Declaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current = this_S_Declaration_0;
                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }


                            }
                            break;
                        case 2 :
                            // InternalGaml.g:1023:4: ( ( ( ruleS_Assignment )=>this_S_Assignment_1= ruleS_Assignment ) | this_S_1Expr_Facets_BlockOrEnd_2= ruleS_1Expr_Facets_BlockOrEnd | this_S_Other_3= ruleS_Other | this_S_Do_4= ruleS_Do | this_S_Return_5= ruleS_Return | this_S_Solve_6= ruleS_Solve | this_S_If_7= ruleS_If | this_S_Try_8= ruleS_Try | this_S_Equations_9= ruleS_Equations )
                            {
                            // InternalGaml.g:1023:4: ( ( ( ruleS_Assignment )=>this_S_Assignment_1= ruleS_Assignment ) | this_S_1Expr_Facets_BlockOrEnd_2= ruleS_1Expr_Facets_BlockOrEnd | this_S_Other_3= ruleS_Other | this_S_Do_4= ruleS_Do | this_S_Return_5= ruleS_Return | this_S_Solve_6= ruleS_Solve | this_S_If_7= ruleS_If | this_S_Try_8= ruleS_Try | this_S_Equations_9= ruleS_Equations )
                            int alt18=9;
                            alt18 = dfa18.predict(input);
                            switch (alt18) {
                                case 1 :
                                    // InternalGaml.g:1024:5: ( ( ruleS_Assignment )=>this_S_Assignment_1= ruleS_Assignment )
                                    {
                                    // InternalGaml.g:1024:5: ( ( ruleS_Assignment )=>this_S_Assignment_1= ruleS_Assignment )
                                    // InternalGaml.g:1025:6: ( ruleS_Assignment )=>this_S_Assignment_1= ruleS_Assignment
                                    {
                                    if ( state.backtracking==0 ) {

                                      						newCompositeNode(grammarAccess.getStatementAccess().getS_AssignmentParserRuleCall_0_1_0());
                                      					
                                    }
                                    pushFollow(FOLLOW_2);
                                    this_S_Assignment_1=ruleS_Assignment();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						current = this_S_Assignment_1;
                                      						afterParserOrEnumRuleCall();
                                      					
                                    }

                                    }


                                    }
                                    break;
                                case 2 :
                                    // InternalGaml.g:1036:5: this_S_1Expr_Facets_BlockOrEnd_2= ruleS_1Expr_Facets_BlockOrEnd
                                    {
                                    if ( state.backtracking==0 ) {

                                      					newCompositeNode(grammarAccess.getStatementAccess().getS_1Expr_Facets_BlockOrEndParserRuleCall_0_1_1());
                                      				
                                    }
                                    pushFollow(FOLLOW_2);
                                    this_S_1Expr_Facets_BlockOrEnd_2=ruleS_1Expr_Facets_BlockOrEnd();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      					current = this_S_1Expr_Facets_BlockOrEnd_2;
                                      					afterParserOrEnumRuleCall();
                                      				
                                    }

                                    }
                                    break;
                                case 3 :
                                    // InternalGaml.g:1045:5: this_S_Other_3= ruleS_Other
                                    {
                                    if ( state.backtracking==0 ) {

                                      					newCompositeNode(grammarAccess.getStatementAccess().getS_OtherParserRuleCall_0_1_2());
                                      				
                                    }
                                    pushFollow(FOLLOW_2);
                                    this_S_Other_3=ruleS_Other();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      					current = this_S_Other_3;
                                      					afterParserOrEnumRuleCall();
                                      				
                                    }

                                    }
                                    break;
                                case 4 :
                                    // InternalGaml.g:1054:5: this_S_Do_4= ruleS_Do
                                    {
                                    if ( state.backtracking==0 ) {

                                      					newCompositeNode(grammarAccess.getStatementAccess().getS_DoParserRuleCall_0_1_3());
                                      				
                                    }
                                    pushFollow(FOLLOW_2);
                                    this_S_Do_4=ruleS_Do();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      					current = this_S_Do_4;
                                      					afterParserOrEnumRuleCall();
                                      				
                                    }

                                    }
                                    break;
                                case 5 :
                                    // InternalGaml.g:1063:5: this_S_Return_5= ruleS_Return
                                    {
                                    if ( state.backtracking==0 ) {

                                      					newCompositeNode(grammarAccess.getStatementAccess().getS_ReturnParserRuleCall_0_1_4());
                                      				
                                    }
                                    pushFollow(FOLLOW_2);
                                    this_S_Return_5=ruleS_Return();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      					current = this_S_Return_5;
                                      					afterParserOrEnumRuleCall();
                                      				
                                    }

                                    }
                                    break;
                                case 6 :
                                    // InternalGaml.g:1072:5: this_S_Solve_6= ruleS_Solve
                                    {
                                    if ( state.backtracking==0 ) {

                                      					newCompositeNode(grammarAccess.getStatementAccess().getS_SolveParserRuleCall_0_1_5());
                                      				
                                    }
                                    pushFollow(FOLLOW_2);
                                    this_S_Solve_6=ruleS_Solve();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      					current = this_S_Solve_6;
                                      					afterParserOrEnumRuleCall();
                                      				
                                    }

                                    }
                                    break;
                                case 7 :
                                    // InternalGaml.g:1081:5: this_S_If_7= ruleS_If
                                    {
                                    if ( state.backtracking==0 ) {

                                      					newCompositeNode(grammarAccess.getStatementAccess().getS_IfParserRuleCall_0_1_6());
                                      				
                                    }
                                    pushFollow(FOLLOW_2);
                                    this_S_If_7=ruleS_If();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      					current = this_S_If_7;
                                      					afterParserOrEnumRuleCall();
                                      				
                                    }

                                    }
                                    break;
                                case 8 :
                                    // InternalGaml.g:1090:5: this_S_Try_8= ruleS_Try
                                    {
                                    if ( state.backtracking==0 ) {

                                      					newCompositeNode(grammarAccess.getStatementAccess().getS_TryParserRuleCall_0_1_7());
                                      				
                                    }
                                    pushFollow(FOLLOW_2);
                                    this_S_Try_8=ruleS_Try();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      					current = this_S_Try_8;
                                      					afterParserOrEnumRuleCall();
                                      				
                                    }

                                    }
                                    break;
                                case 9 :
                                    // InternalGaml.g:1099:5: this_S_Equations_9= ruleS_Equations
                                    {
                                    if ( state.backtracking==0 ) {

                                      					newCompositeNode(grammarAccess.getStatementAccess().getS_EquationsParserRuleCall_0_1_8());
                                      				
                                    }
                                    pushFollow(FOLLOW_2);
                                    this_S_Equations_9=ruleS_Equations();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      					current = this_S_Equations_9;
                                      					afterParserOrEnumRuleCall();
                                      				
                                    }

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:1110:3: this_S_Display_10= ruleS_Display
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getS_DisplayParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Display_10=ruleS_Display();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_S_Display_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleS_1Expr_Facets_BlockOrEnd"
    // InternalGaml.g:1122:1: entryRuleS_1Expr_Facets_BlockOrEnd returns [EObject current=null] : iv_ruleS_1Expr_Facets_BlockOrEnd= ruleS_1Expr_Facets_BlockOrEnd EOF ;
    public final EObject entryRuleS_1Expr_Facets_BlockOrEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_1Expr_Facets_BlockOrEnd = null;


        try {
            // InternalGaml.g:1122:66: (iv_ruleS_1Expr_Facets_BlockOrEnd= ruleS_1Expr_Facets_BlockOrEnd EOF )
            // InternalGaml.g:1123:2: iv_ruleS_1Expr_Facets_BlockOrEnd= ruleS_1Expr_Facets_BlockOrEnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_1Expr_Facets_BlockOrEndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_1Expr_Facets_BlockOrEnd=ruleS_1Expr_Facets_BlockOrEnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_1Expr_Facets_BlockOrEnd; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_1Expr_Facets_BlockOrEnd"


    // $ANTLR start "ruleS_1Expr_Facets_BlockOrEnd"
    // InternalGaml.g:1129:1: ruleS_1Expr_Facets_BlockOrEnd returns [EObject current=null] : ( ( (lv_key_0_0= rule_1Expr_Facets_BlockOrEnd_Key ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) ) ;
    public final EObject ruleS_1Expr_Facets_BlockOrEnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_expr_1_0 = null;

        EObject lv_facets_2_0 = null;

        EObject lv_block_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:1135:2: ( ( ( (lv_key_0_0= rule_1Expr_Facets_BlockOrEnd_Key ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) ) )
            // InternalGaml.g:1136:2: ( ( (lv_key_0_0= rule_1Expr_Facets_BlockOrEnd_Key ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) )
            {
            // InternalGaml.g:1136:2: ( ( (lv_key_0_0= rule_1Expr_Facets_BlockOrEnd_Key ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) )
            // InternalGaml.g:1137:3: ( (lv_key_0_0= rule_1Expr_Facets_BlockOrEnd_Key ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' )
            {
            // InternalGaml.g:1137:3: ( (lv_key_0_0= rule_1Expr_Facets_BlockOrEnd_Key ) )
            // InternalGaml.g:1138:4: (lv_key_0_0= rule_1Expr_Facets_BlockOrEnd_Key )
            {
            // InternalGaml.g:1138:4: (lv_key_0_0= rule_1Expr_Facets_BlockOrEnd_Key )
            // InternalGaml.g:1139:5: lv_key_0_0= rule_1Expr_Facets_BlockOrEnd_Key
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_1Expr_Facets_BlockOrEndAccess().getKey_1Expr_Facets_BlockOrEnd_KeyParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_key_0_0=rule_1Expr_Facets_BlockOrEnd_Key();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_1Expr_Facets_BlockOrEndRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_0_0,
              						"gama.core.lang.Gaml._1Expr_Facets_BlockOrEnd_Key");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:1156:3: ( (lv_expr_1_0= ruleExpression ) )
            // InternalGaml.g:1157:4: (lv_expr_1_0= ruleExpression )
            {
            // InternalGaml.g:1157:4: (lv_expr_1_0= ruleExpression )
            // InternalGaml.g:1158:5: lv_expr_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_1Expr_Facets_BlockOrEndAccess().getExprExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_expr_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_1Expr_Facets_BlockOrEndRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_1_0,
              						"gama.core.lang.Gaml.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:1175:3: ( (lv_facets_2_0= ruleFacet ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID||LA21_0==15||LA21_0==29||(LA21_0>=95 && LA21_0<=119)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalGaml.g:1176:4: (lv_facets_2_0= ruleFacet )
            	    {
            	    // InternalGaml.g:1176:4: (lv_facets_2_0= ruleFacet )
            	    // InternalGaml.g:1177:5: lv_facets_2_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getS_1Expr_Facets_BlockOrEndAccess().getFacetsFacetParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_facets_2_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getS_1Expr_Facets_BlockOrEndRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_2_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // InternalGaml.g:1194:3: ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==34) ) {
                alt22=1;
            }
            else if ( (LA22_0==21) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalGaml.g:1195:4: ( (lv_block_3_0= ruleBlock ) )
                    {
                    // InternalGaml.g:1195:4: ( (lv_block_3_0= ruleBlock ) )
                    // InternalGaml.g:1196:5: (lv_block_3_0= ruleBlock )
                    {
                    // InternalGaml.g:1196:5: (lv_block_3_0= ruleBlock )
                    // InternalGaml.g:1197:6: lv_block_3_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_1Expr_Facets_BlockOrEndAccess().getBlockBlockParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_3_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_1Expr_Facets_BlockOrEndRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_3_0,
                      							"gama.core.lang.Gaml.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:1215:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getS_1Expr_Facets_BlockOrEndAccess().getSemicolonKeyword_3_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_1Expr_Facets_BlockOrEnd"


    // $ANTLR start "entryRuleS_Do"
    // InternalGaml.g:1224:1: entryRuleS_Do returns [EObject current=null] : iv_ruleS_Do= ruleS_Do EOF ;
    public final EObject entryRuleS_Do() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Do = null;


        try {
            // InternalGaml.g:1224:45: (iv_ruleS_Do= ruleS_Do EOF )
            // InternalGaml.g:1225:2: iv_ruleS_Do= ruleS_Do EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_DoRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Do=ruleS_Do();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Do; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Do"


    // $ANTLR start "ruleS_Do"
    // InternalGaml.g:1231:1: ruleS_Do returns [EObject current=null] : ( ( (lv_key_0_0= rule_DoKey ) ) ( (lv_expr_1_0= ruleAbstractRef ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) ) ;
    public final EObject ruleS_Do() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_expr_1_0 = null;

        EObject lv_facets_2_0 = null;

        EObject lv_block_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:1237:2: ( ( ( (lv_key_0_0= rule_DoKey ) ) ( (lv_expr_1_0= ruleAbstractRef ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) ) )
            // InternalGaml.g:1238:2: ( ( (lv_key_0_0= rule_DoKey ) ) ( (lv_expr_1_0= ruleAbstractRef ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) )
            {
            // InternalGaml.g:1238:2: ( ( (lv_key_0_0= rule_DoKey ) ) ( (lv_expr_1_0= ruleAbstractRef ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) )
            // InternalGaml.g:1239:3: ( (lv_key_0_0= rule_DoKey ) ) ( (lv_expr_1_0= ruleAbstractRef ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' )
            {
            // InternalGaml.g:1239:3: ( (lv_key_0_0= rule_DoKey ) )
            // InternalGaml.g:1240:4: (lv_key_0_0= rule_DoKey )
            {
            // InternalGaml.g:1240:4: (lv_key_0_0= rule_DoKey )
            // InternalGaml.g:1241:5: lv_key_0_0= rule_DoKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_DoAccess().getKey_DoKeyParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_key_0_0=rule_DoKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_DoRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_0_0,
              						"gama.core.lang.Gaml._DoKey");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:1258:3: ( (lv_expr_1_0= ruleAbstractRef ) )
            // InternalGaml.g:1259:4: (lv_expr_1_0= ruleAbstractRef )
            {
            // InternalGaml.g:1259:4: (lv_expr_1_0= ruleAbstractRef )
            // InternalGaml.g:1260:5: lv_expr_1_0= ruleAbstractRef
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_DoAccess().getExprAbstractRefParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_expr_1_0=ruleAbstractRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_DoRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_1_0,
              						"gama.core.lang.Gaml.AbstractRef");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:1277:3: ( (lv_facets_2_0= ruleFacet ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ID||LA23_0==15||LA23_0==29||(LA23_0>=95 && LA23_0<=119)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalGaml.g:1278:4: (lv_facets_2_0= ruleFacet )
            	    {
            	    // InternalGaml.g:1278:4: (lv_facets_2_0= ruleFacet )
            	    // InternalGaml.g:1279:5: lv_facets_2_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getS_DoAccess().getFacetsFacetParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_facets_2_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getS_DoRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_2_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // InternalGaml.g:1296:3: ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==34) ) {
                alt24=1;
            }
            else if ( (LA24_0==21) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalGaml.g:1297:4: ( (lv_block_3_0= ruleBlock ) )
                    {
                    // InternalGaml.g:1297:4: ( (lv_block_3_0= ruleBlock ) )
                    // InternalGaml.g:1298:5: (lv_block_3_0= ruleBlock )
                    {
                    // InternalGaml.g:1298:5: (lv_block_3_0= ruleBlock )
                    // InternalGaml.g:1299:6: lv_block_3_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_DoAccess().getBlockBlockParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_3_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_DoRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_3_0,
                      							"gama.core.lang.Gaml.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:1317:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getS_DoAccess().getSemicolonKeyword_3_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Do"


    // $ANTLR start "entryRuleS_Loop"
    // InternalGaml.g:1326:1: entryRuleS_Loop returns [EObject current=null] : iv_ruleS_Loop= ruleS_Loop EOF ;
    public final EObject entryRuleS_Loop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Loop = null;


        try {
            // InternalGaml.g:1326:47: (iv_ruleS_Loop= ruleS_Loop EOF )
            // InternalGaml.g:1327:2: iv_ruleS_Loop= ruleS_Loop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_LoopRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Loop=ruleS_Loop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Loop; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Loop"


    // $ANTLR start "ruleS_Loop"
    // InternalGaml.g:1333:1: ruleS_Loop returns [EObject current=null] : ( ( (lv_key_0_0= 'loop' ) ) ( (lv_name_1_0= RULE_ID ) )? ( (lv_facets_2_0= ruleFacet ) )* ( (lv_block_3_0= ruleBlock ) ) ) ;
    public final EObject ruleS_Loop() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token lv_name_1_0=null;
        EObject lv_facets_2_0 = null;

        EObject lv_block_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:1339:2: ( ( ( (lv_key_0_0= 'loop' ) ) ( (lv_name_1_0= RULE_ID ) )? ( (lv_facets_2_0= ruleFacet ) )* ( (lv_block_3_0= ruleBlock ) ) ) )
            // InternalGaml.g:1340:2: ( ( (lv_key_0_0= 'loop' ) ) ( (lv_name_1_0= RULE_ID ) )? ( (lv_facets_2_0= ruleFacet ) )* ( (lv_block_3_0= ruleBlock ) ) )
            {
            // InternalGaml.g:1340:2: ( ( (lv_key_0_0= 'loop' ) ) ( (lv_name_1_0= RULE_ID ) )? ( (lv_facets_2_0= ruleFacet ) )* ( (lv_block_3_0= ruleBlock ) ) )
            // InternalGaml.g:1341:3: ( (lv_key_0_0= 'loop' ) ) ( (lv_name_1_0= RULE_ID ) )? ( (lv_facets_2_0= ruleFacet ) )* ( (lv_block_3_0= ruleBlock ) )
            {
            // InternalGaml.g:1341:3: ( (lv_key_0_0= 'loop' ) )
            // InternalGaml.g:1342:4: (lv_key_0_0= 'loop' )
            {
            // InternalGaml.g:1342:4: (lv_key_0_0= 'loop' )
            // InternalGaml.g:1343:5: lv_key_0_0= 'loop'
            {
            lv_key_0_0=(Token)match(input,23,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_key_0_0, grammarAccess.getS_LoopAccess().getKeyLoopKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getS_LoopRule());
              					}
              					setWithLastConsumed(current, "key", lv_key_0_0, "loop");
              				
            }

            }


            }

            // InternalGaml.g:1355:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==RULE_ID||LA25_1==15||LA25_1==29||LA25_1==34||(LA25_1>=95 && LA25_1<=119)) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // InternalGaml.g:1356:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalGaml.g:1356:4: (lv_name_1_0= RULE_ID )
                    // InternalGaml.g:1357:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_name_1_0, grammarAccess.getS_LoopAccess().getNameIDTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getS_LoopRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"name",
                      						lv_name_1_0,
                      						"gama.core.lang.Gaml.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalGaml.g:1373:3: ( (lv_facets_2_0= ruleFacet ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID||LA26_0==15||LA26_0==29||(LA26_0>=95 && LA26_0<=119)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalGaml.g:1374:4: (lv_facets_2_0= ruleFacet )
            	    {
            	    // InternalGaml.g:1374:4: (lv_facets_2_0= ruleFacet )
            	    // InternalGaml.g:1375:5: lv_facets_2_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getS_LoopAccess().getFacetsFacetParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_facets_2_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getS_LoopRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_2_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            // InternalGaml.g:1392:3: ( (lv_block_3_0= ruleBlock ) )
            // InternalGaml.g:1393:4: (lv_block_3_0= ruleBlock )
            {
            // InternalGaml.g:1393:4: (lv_block_3_0= ruleBlock )
            // InternalGaml.g:1394:5: lv_block_3_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_LoopAccess().getBlockBlockParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_block_3_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_LoopRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_3_0,
              						"gama.core.lang.Gaml.Block");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Loop"


    // $ANTLR start "entryRuleS_If"
    // InternalGaml.g:1415:1: entryRuleS_If returns [EObject current=null] : iv_ruleS_If= ruleS_If EOF ;
    public final EObject entryRuleS_If() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_If = null;


        try {
            // InternalGaml.g:1415:45: (iv_ruleS_If= ruleS_If EOF )
            // InternalGaml.g:1416:2: iv_ruleS_If= ruleS_If EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_IfRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_If=ruleS_If();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_If; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_If"


    // $ANTLR start "ruleS_If"
    // InternalGaml.g:1422:1: ruleS_If returns [EObject current=null] : ( ( (lv_key_0_0= 'if' ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_block_2_0= ruleBlock ) ) ( ( ( 'else' )=>otherlv_3= 'else' ) ( ( (lv_else_4_1= ruleS_If | lv_else_4_2= ruleBlock ) ) ) )? ) ;
    public final EObject ruleS_If() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_3=null;
        EObject lv_expr_1_0 = null;

        EObject lv_block_2_0 = null;

        EObject lv_else_4_1 = null;

        EObject lv_else_4_2 = null;



        	enterRule();

        try {
            // InternalGaml.g:1428:2: ( ( ( (lv_key_0_0= 'if' ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_block_2_0= ruleBlock ) ) ( ( ( 'else' )=>otherlv_3= 'else' ) ( ( (lv_else_4_1= ruleS_If | lv_else_4_2= ruleBlock ) ) ) )? ) )
            // InternalGaml.g:1429:2: ( ( (lv_key_0_0= 'if' ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_block_2_0= ruleBlock ) ) ( ( ( 'else' )=>otherlv_3= 'else' ) ( ( (lv_else_4_1= ruleS_If | lv_else_4_2= ruleBlock ) ) ) )? )
            {
            // InternalGaml.g:1429:2: ( ( (lv_key_0_0= 'if' ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_block_2_0= ruleBlock ) ) ( ( ( 'else' )=>otherlv_3= 'else' ) ( ( (lv_else_4_1= ruleS_If | lv_else_4_2= ruleBlock ) ) ) )? )
            // InternalGaml.g:1430:3: ( (lv_key_0_0= 'if' ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_block_2_0= ruleBlock ) ) ( ( ( 'else' )=>otherlv_3= 'else' ) ( ( (lv_else_4_1= ruleS_If | lv_else_4_2= ruleBlock ) ) ) )?
            {
            // InternalGaml.g:1430:3: ( (lv_key_0_0= 'if' ) )
            // InternalGaml.g:1431:4: (lv_key_0_0= 'if' )
            {
            // InternalGaml.g:1431:4: (lv_key_0_0= 'if' )
            // InternalGaml.g:1432:5: lv_key_0_0= 'if'
            {
            lv_key_0_0=(Token)match(input,24,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_key_0_0, grammarAccess.getS_IfAccess().getKeyIfKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getS_IfRule());
              					}
              					setWithLastConsumed(current, "key", lv_key_0_0, "if");
              				
            }

            }


            }

            // InternalGaml.g:1444:3: ( (lv_expr_1_0= ruleExpression ) )
            // InternalGaml.g:1445:4: (lv_expr_1_0= ruleExpression )
            {
            // InternalGaml.g:1445:4: (lv_expr_1_0= ruleExpression )
            // InternalGaml.g:1446:5: lv_expr_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_IfAccess().getExprExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_expr_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_IfRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_1_0,
              						"gama.core.lang.Gaml.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:1463:3: ( (lv_block_2_0= ruleBlock ) )
            // InternalGaml.g:1464:4: (lv_block_2_0= ruleBlock )
            {
            // InternalGaml.g:1464:4: (lv_block_2_0= ruleBlock )
            // InternalGaml.g:1465:5: lv_block_2_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_IfAccess().getBlockBlockParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_17);
            lv_block_2_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_IfRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_2_0,
              						"gama.core.lang.Gaml.Block");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:1482:3: ( ( ( 'else' )=>otherlv_3= 'else' ) ( ( (lv_else_4_1= ruleS_If | lv_else_4_2= ruleBlock ) ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==25) && (synpred4_InternalGaml())) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalGaml.g:1483:4: ( ( 'else' )=>otherlv_3= 'else' ) ( ( (lv_else_4_1= ruleS_If | lv_else_4_2= ruleBlock ) ) )
                    {
                    // InternalGaml.g:1483:4: ( ( 'else' )=>otherlv_3= 'else' )
                    // InternalGaml.g:1484:5: ( 'else' )=>otherlv_3= 'else'
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getS_IfAccess().getElseKeyword_3_0());
                      				
                    }

                    }

                    // InternalGaml.g:1490:4: ( ( (lv_else_4_1= ruleS_If | lv_else_4_2= ruleBlock ) ) )
                    // InternalGaml.g:1491:5: ( (lv_else_4_1= ruleS_If | lv_else_4_2= ruleBlock ) )
                    {
                    // InternalGaml.g:1491:5: ( (lv_else_4_1= ruleS_If | lv_else_4_2= ruleBlock ) )
                    // InternalGaml.g:1492:6: (lv_else_4_1= ruleS_If | lv_else_4_2= ruleBlock )
                    {
                    // InternalGaml.g:1492:6: (lv_else_4_1= ruleS_If | lv_else_4_2= ruleBlock )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==24) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==34) ) {
                        alt27=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalGaml.g:1493:7: lv_else_4_1= ruleS_If
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getS_IfAccess().getElseS_IfParserRuleCall_3_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_else_4_1=ruleS_If();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getS_IfRule());
                              							}
                              							set(
                              								current,
                              								"else",
                              								lv_else_4_1,
                              								"gama.core.lang.Gaml.S_If");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalGaml.g:1509:7: lv_else_4_2= ruleBlock
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getS_IfAccess().getElseBlockParserRuleCall_3_1_0_1());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_else_4_2=ruleBlock();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getS_IfRule());
                              							}
                              							set(
                              								current,
                              								"else",
                              								lv_else_4_2,
                              								"gama.core.lang.Gaml.Block");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_If"


    // $ANTLR start "entryRuleS_Try"
    // InternalGaml.g:1532:1: entryRuleS_Try returns [EObject current=null] : iv_ruleS_Try= ruleS_Try EOF ;
    public final EObject entryRuleS_Try() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Try = null;


        try {
            // InternalGaml.g:1532:46: (iv_ruleS_Try= ruleS_Try EOF )
            // InternalGaml.g:1533:2: iv_ruleS_Try= ruleS_Try EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_TryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Try=ruleS_Try();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Try; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Try"


    // $ANTLR start "ruleS_Try"
    // InternalGaml.g:1539:1: ruleS_Try returns [EObject current=null] : ( ( (lv_key_0_0= 'try' ) ) ( (lv_block_1_0= ruleBlock ) ) ( ( ( 'catch' )=>otherlv_2= 'catch' ) ( (lv_catch_3_0= ruleBlock ) ) )? ) ;
    public final EObject ruleS_Try() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_2=null;
        EObject lv_block_1_0 = null;

        EObject lv_catch_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:1545:2: ( ( ( (lv_key_0_0= 'try' ) ) ( (lv_block_1_0= ruleBlock ) ) ( ( ( 'catch' )=>otherlv_2= 'catch' ) ( (lv_catch_3_0= ruleBlock ) ) )? ) )
            // InternalGaml.g:1546:2: ( ( (lv_key_0_0= 'try' ) ) ( (lv_block_1_0= ruleBlock ) ) ( ( ( 'catch' )=>otherlv_2= 'catch' ) ( (lv_catch_3_0= ruleBlock ) ) )? )
            {
            // InternalGaml.g:1546:2: ( ( (lv_key_0_0= 'try' ) ) ( (lv_block_1_0= ruleBlock ) ) ( ( ( 'catch' )=>otherlv_2= 'catch' ) ( (lv_catch_3_0= ruleBlock ) ) )? )
            // InternalGaml.g:1547:3: ( (lv_key_0_0= 'try' ) ) ( (lv_block_1_0= ruleBlock ) ) ( ( ( 'catch' )=>otherlv_2= 'catch' ) ( (lv_catch_3_0= ruleBlock ) ) )?
            {
            // InternalGaml.g:1547:3: ( (lv_key_0_0= 'try' ) )
            // InternalGaml.g:1548:4: (lv_key_0_0= 'try' )
            {
            // InternalGaml.g:1548:4: (lv_key_0_0= 'try' )
            // InternalGaml.g:1549:5: lv_key_0_0= 'try'
            {
            lv_key_0_0=(Token)match(input,26,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_key_0_0, grammarAccess.getS_TryAccess().getKeyTryKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getS_TryRule());
              					}
              					setWithLastConsumed(current, "key", lv_key_0_0, "try");
              				
            }

            }


            }

            // InternalGaml.g:1561:3: ( (lv_block_1_0= ruleBlock ) )
            // InternalGaml.g:1562:4: (lv_block_1_0= ruleBlock )
            {
            // InternalGaml.g:1562:4: (lv_block_1_0= ruleBlock )
            // InternalGaml.g:1563:5: lv_block_1_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_TryAccess().getBlockBlockParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_block_1_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_TryRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_1_0,
              						"gama.core.lang.Gaml.Block");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:1580:3: ( ( ( 'catch' )=>otherlv_2= 'catch' ) ( (lv_catch_3_0= ruleBlock ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==27) && (synpred5_InternalGaml())) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalGaml.g:1581:4: ( ( 'catch' )=>otherlv_2= 'catch' ) ( (lv_catch_3_0= ruleBlock ) )
                    {
                    // InternalGaml.g:1581:4: ( ( 'catch' )=>otherlv_2= 'catch' )
                    // InternalGaml.g:1582:5: ( 'catch' )=>otherlv_2= 'catch'
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getS_TryAccess().getCatchKeyword_2_0());
                      				
                    }

                    }

                    // InternalGaml.g:1588:4: ( (lv_catch_3_0= ruleBlock ) )
                    // InternalGaml.g:1589:5: (lv_catch_3_0= ruleBlock )
                    {
                    // InternalGaml.g:1589:5: (lv_catch_3_0= ruleBlock )
                    // InternalGaml.g:1590:6: lv_catch_3_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_TryAccess().getCatchBlockParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_catch_3_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_TryRule());
                      						}
                      						set(
                      							current,
                      							"catch",
                      							lv_catch_3_0,
                      							"gama.core.lang.Gaml.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Try"


    // $ANTLR start "entryRuleS_Other"
    // InternalGaml.g:1612:1: entryRuleS_Other returns [EObject current=null] : iv_ruleS_Other= ruleS_Other EOF ;
    public final EObject entryRuleS_Other() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Other = null;


        try {
            // InternalGaml.g:1612:48: (iv_ruleS_Other= ruleS_Other EOF )
            // InternalGaml.g:1613:2: iv_ruleS_Other= ruleS_Other EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_OtherRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Other=ruleS_Other();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Other; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Other"


    // $ANTLR start "ruleS_Other"
    // InternalGaml.g:1619:1: ruleS_Other returns [EObject current=null] : ( ( (lv_key_0_0= RULE_ID ) ) ( (lv_facets_1_0= ruleFacet ) )* ( ( (lv_block_2_0= ruleBlock ) ) | otherlv_3= ';' ) ) ;
    public final EObject ruleS_Other() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_3=null;
        EObject lv_facets_1_0 = null;

        EObject lv_block_2_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:1625:2: ( ( ( (lv_key_0_0= RULE_ID ) ) ( (lv_facets_1_0= ruleFacet ) )* ( ( (lv_block_2_0= ruleBlock ) ) | otherlv_3= ';' ) ) )
            // InternalGaml.g:1626:2: ( ( (lv_key_0_0= RULE_ID ) ) ( (lv_facets_1_0= ruleFacet ) )* ( ( (lv_block_2_0= ruleBlock ) ) | otherlv_3= ';' ) )
            {
            // InternalGaml.g:1626:2: ( ( (lv_key_0_0= RULE_ID ) ) ( (lv_facets_1_0= ruleFacet ) )* ( ( (lv_block_2_0= ruleBlock ) ) | otherlv_3= ';' ) )
            // InternalGaml.g:1627:3: ( (lv_key_0_0= RULE_ID ) ) ( (lv_facets_1_0= ruleFacet ) )* ( ( (lv_block_2_0= ruleBlock ) ) | otherlv_3= ';' )
            {
            // InternalGaml.g:1627:3: ( (lv_key_0_0= RULE_ID ) )
            // InternalGaml.g:1628:4: (lv_key_0_0= RULE_ID )
            {
            // InternalGaml.g:1628:4: (lv_key_0_0= RULE_ID )
            // InternalGaml.g:1629:5: lv_key_0_0= RULE_ID
            {
            lv_key_0_0=(Token)match(input,RULE_ID,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_key_0_0, grammarAccess.getS_OtherAccess().getKeyIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getS_OtherRule());
              					}
              					setWithLastConsumed(
              						current,
              						"key",
              						lv_key_0_0,
              						"gama.core.lang.Gaml.ID");
              				
            }

            }


            }

            // InternalGaml.g:1645:3: ( (lv_facets_1_0= ruleFacet ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID||LA30_0==15||LA30_0==29||(LA30_0>=95 && LA30_0<=119)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalGaml.g:1646:4: (lv_facets_1_0= ruleFacet )
            	    {
            	    // InternalGaml.g:1646:4: (lv_facets_1_0= ruleFacet )
            	    // InternalGaml.g:1647:5: lv_facets_1_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getS_OtherAccess().getFacetsFacetParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_facets_1_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getS_OtherRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_1_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            // InternalGaml.g:1664:3: ( ( (lv_block_2_0= ruleBlock ) ) | otherlv_3= ';' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==34) ) {
                alt31=1;
            }
            else if ( (LA31_0==21) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalGaml.g:1665:4: ( (lv_block_2_0= ruleBlock ) )
                    {
                    // InternalGaml.g:1665:4: ( (lv_block_2_0= ruleBlock ) )
                    // InternalGaml.g:1666:5: (lv_block_2_0= ruleBlock )
                    {
                    // InternalGaml.g:1666:5: (lv_block_2_0= ruleBlock )
                    // InternalGaml.g:1667:6: lv_block_2_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_OtherAccess().getBlockBlockParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_2_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_OtherRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_2_0,
                      							"gama.core.lang.Gaml.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:1685:4: otherlv_3= ';'
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getS_OtherAccess().getSemicolonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Other"


    // $ANTLR start "entryRuleS_Return"
    // InternalGaml.g:1694:1: entryRuleS_Return returns [EObject current=null] : iv_ruleS_Return= ruleS_Return EOF ;
    public final EObject entryRuleS_Return() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Return = null;


        try {
            // InternalGaml.g:1694:49: (iv_ruleS_Return= ruleS_Return EOF )
            // InternalGaml.g:1695:2: iv_ruleS_Return= ruleS_Return EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_ReturnRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Return=ruleS_Return();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Return; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Return"


    // $ANTLR start "ruleS_Return"
    // InternalGaml.g:1701:1: ruleS_Return returns [EObject current=null] : ( ( (lv_key_0_0= 'return' ) ) ( (lv_expr_1_0= ruleExpression ) )? otherlv_2= ';' ) ;
    public final EObject ruleS_Return() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_2=null;
        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:1707:2: ( ( ( (lv_key_0_0= 'return' ) ) ( (lv_expr_1_0= ruleExpression ) )? otherlv_2= ';' ) )
            // InternalGaml.g:1708:2: ( ( (lv_key_0_0= 'return' ) ) ( (lv_expr_1_0= ruleExpression ) )? otherlv_2= ';' )
            {
            // InternalGaml.g:1708:2: ( ( (lv_key_0_0= 'return' ) ) ( (lv_expr_1_0= ruleExpression ) )? otherlv_2= ';' )
            // InternalGaml.g:1709:3: ( (lv_key_0_0= 'return' ) ) ( (lv_expr_1_0= ruleExpression ) )? otherlv_2= ';'
            {
            // InternalGaml.g:1709:3: ( (lv_key_0_0= 'return' ) )
            // InternalGaml.g:1710:4: (lv_key_0_0= 'return' )
            {
            // InternalGaml.g:1710:4: (lv_key_0_0= 'return' )
            // InternalGaml.g:1711:5: lv_key_0_0= 'return'
            {
            lv_key_0_0=(Token)match(input,28,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_key_0_0, grammarAccess.getS_ReturnAccess().getKeyReturnKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getS_ReturnRule());
              					}
              					setWithLastConsumed(current, "key", lv_key_0_0, "return");
              				
            }

            }


            }

            // InternalGaml.g:1723:3: ( (lv_expr_1_0= ruleExpression ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_KEYWORD)||LA32_0==29||LA32_0==31||LA32_0==34||LA32_0==38||(LA32_0>=40 && LA32_0<=87)||(LA32_0>=95 && LA32_0<=118)||LA32_0==129||(LA32_0>=133 && LA32_0<=138)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalGaml.g:1724:4: (lv_expr_1_0= ruleExpression )
                    {
                    // InternalGaml.g:1724:4: (lv_expr_1_0= ruleExpression )
                    // InternalGaml.g:1725:5: lv_expr_1_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getS_ReturnAccess().getExprExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_21);
                    lv_expr_1_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getS_ReturnRule());
                      					}
                      					set(
                      						current,
                      						"expr",
                      						lv_expr_1_0,
                      						"gama.core.lang.Gaml.Expression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getS_ReturnAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Return"


    // $ANTLR start "entryRuleS_Declaration"
    // InternalGaml.g:1750:1: entryRuleS_Declaration returns [EObject current=null] : iv_ruleS_Declaration= ruleS_Declaration EOF ;
    public final EObject entryRuleS_Declaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Declaration = null;


        try {
            // InternalGaml.g:1750:54: (iv_ruleS_Declaration= ruleS_Declaration EOF )
            // InternalGaml.g:1751:2: iv_ruleS_Declaration= ruleS_Declaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_DeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Declaration=ruleS_Declaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Declaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Declaration"


    // $ANTLR start "ruleS_Declaration"
    // InternalGaml.g:1757:1: ruleS_Declaration returns [EObject current=null] : ( ( ( 'species' | RULE_ID )=>this_S_Definition_0= ruleS_Definition ) | this_S_Species_1= ruleS_Species | this_S_Reflex_2= ruleS_Reflex | this_S_Action_3= ruleS_Action | this_S_Loop_4= ruleS_Loop ) ;
    public final EObject ruleS_Declaration() throws RecognitionException {
        EObject current = null;

        EObject this_S_Definition_0 = null;

        EObject this_S_Species_1 = null;

        EObject this_S_Reflex_2 = null;

        EObject this_S_Action_3 = null;

        EObject this_S_Loop_4 = null;



        	enterRule();

        try {
            // InternalGaml.g:1763:2: ( ( ( ( 'species' | RULE_ID )=>this_S_Definition_0= ruleS_Definition ) | this_S_Species_1= ruleS_Species | this_S_Reflex_2= ruleS_Reflex | this_S_Action_3= ruleS_Action | this_S_Loop_4= ruleS_Loop ) )
            // InternalGaml.g:1764:2: ( ( ( 'species' | RULE_ID )=>this_S_Definition_0= ruleS_Definition ) | this_S_Species_1= ruleS_Species | this_S_Reflex_2= ruleS_Reflex | this_S_Action_3= ruleS_Action | this_S_Loop_4= ruleS_Loop )
            {
            // InternalGaml.g:1764:2: ( ( ( 'species' | RULE_ID )=>this_S_Definition_0= ruleS_Definition ) | this_S_Species_1= ruleS_Species | this_S_Reflex_2= ruleS_Reflex | this_S_Action_3= ruleS_Action | this_S_Loop_4= ruleS_Loop )
            int alt33=5;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) && (synpred6_InternalGaml())) {
                alt33=1;
            }
            else if ( (LA33_0==40) ) {
                int LA33_2 = input.LA(2);

                if ( (LA33_2==RULE_ID) ) {
                    alt33=2;
                }
                else if ( (LA33_2==127) && (synpred6_InternalGaml())) {
                    alt33=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 2, input);

                    throw nvae;
                }
            }
            else if ( (LA33_0==41) ) {
                alt33=2;
            }
            else if ( ((LA33_0>=85 && LA33_0<=87)) ) {
                alt33=3;
            }
            else if ( (LA33_0==33) ) {
                alt33=4;
            }
            else if ( (LA33_0==23) ) {
                alt33=5;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalGaml.g:1765:3: ( ( 'species' | RULE_ID )=>this_S_Definition_0= ruleS_Definition )
                    {
                    // InternalGaml.g:1765:3: ( ( 'species' | RULE_ID )=>this_S_Definition_0= ruleS_Definition )
                    // InternalGaml.g:1766:4: ( 'species' | RULE_ID )=>this_S_Definition_0= ruleS_Definition
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getS_DeclarationAccess().getS_DefinitionParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Definition_0=ruleS_Definition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_S_Definition_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:1777:3: this_S_Species_1= ruleS_Species
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getS_DeclarationAccess().getS_SpeciesParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Species_1=ruleS_Species();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_S_Species_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGaml.g:1786:3: this_S_Reflex_2= ruleS_Reflex
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getS_DeclarationAccess().getS_ReflexParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Reflex_2=ruleS_Reflex();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_S_Reflex_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalGaml.g:1795:3: this_S_Action_3= ruleS_Action
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getS_DeclarationAccess().getS_ActionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Action_3=ruleS_Action();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_S_Action_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalGaml.g:1804:3: this_S_Loop_4= ruleS_Loop
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getS_DeclarationAccess().getS_LoopParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Loop_4=ruleS_Loop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_S_Loop_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Declaration"


    // $ANTLR start "entryRuleS_Reflex"
    // InternalGaml.g:1816:1: entryRuleS_Reflex returns [EObject current=null] : iv_ruleS_Reflex= ruleS_Reflex EOF ;
    public final EObject entryRuleS_Reflex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Reflex = null;


        try {
            // InternalGaml.g:1816:49: (iv_ruleS_Reflex= ruleS_Reflex EOF )
            // InternalGaml.g:1817:2: iv_ruleS_Reflex= ruleS_Reflex EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_ReflexRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Reflex=ruleS_Reflex();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Reflex; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Reflex"


    // $ANTLR start "ruleS_Reflex"
    // InternalGaml.g:1823:1: ruleS_Reflex returns [EObject current=null] : ( ( (lv_key_0_0= rule_ReflexKey ) ) ( (lv_name_1_0= ruleValid_ID ) )? (otherlv_2= 'when' otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) )? ( (lv_block_5_0= ruleBlock ) ) ) ;
    public final EObject ruleS_Reflex() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_expr_4_0 = null;

        EObject lv_block_5_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:1829:2: ( ( ( (lv_key_0_0= rule_ReflexKey ) ) ( (lv_name_1_0= ruleValid_ID ) )? (otherlv_2= 'when' otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) )? ( (lv_block_5_0= ruleBlock ) ) ) )
            // InternalGaml.g:1830:2: ( ( (lv_key_0_0= rule_ReflexKey ) ) ( (lv_name_1_0= ruleValid_ID ) )? (otherlv_2= 'when' otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) )? ( (lv_block_5_0= ruleBlock ) ) )
            {
            // InternalGaml.g:1830:2: ( ( (lv_key_0_0= rule_ReflexKey ) ) ( (lv_name_1_0= ruleValid_ID ) )? (otherlv_2= 'when' otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) )? ( (lv_block_5_0= ruleBlock ) ) )
            // InternalGaml.g:1831:3: ( (lv_key_0_0= rule_ReflexKey ) ) ( (lv_name_1_0= ruleValid_ID ) )? (otherlv_2= 'when' otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) )? ( (lv_block_5_0= ruleBlock ) )
            {
            // InternalGaml.g:1831:3: ( (lv_key_0_0= rule_ReflexKey ) )
            // InternalGaml.g:1832:4: (lv_key_0_0= rule_ReflexKey )
            {
            // InternalGaml.g:1832:4: (lv_key_0_0= rule_ReflexKey )
            // InternalGaml.g:1833:5: lv_key_0_0= rule_ReflexKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_ReflexAccess().getKey_ReflexKeyParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_key_0_0=rule_ReflexKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_ReflexRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_0_0,
              						"gama.core.lang.Gaml._ReflexKey");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:1850:3: ( (lv_name_1_0= ruleValid_ID ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID||LA34_0==38||(LA34_0>=40 && LA34_0<=87)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalGaml.g:1851:4: (lv_name_1_0= ruleValid_ID )
                    {
                    // InternalGaml.g:1851:4: (lv_name_1_0= ruleValid_ID )
                    // InternalGaml.g:1852:5: lv_name_1_0= ruleValid_ID
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getS_ReflexAccess().getNameValid_IDParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_23);
                    lv_name_1_0=ruleValid_ID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getS_ReflexRule());
                      					}
                      					set(
                      						current,
                      						"name",
                      						lv_name_1_0,
                      						"gama.core.lang.Gaml.Valid_ID");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalGaml.g:1869:3: (otherlv_2= 'when' otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==29) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalGaml.g:1870:4: otherlv_2= 'when' otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,29,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getS_ReflexAccess().getWhenKeyword_2_0());
                      			
                    }
                    otherlv_3=(Token)match(input,30,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getS_ReflexAccess().getColonKeyword_2_1());
                      			
                    }
                    // InternalGaml.g:1878:4: ( (lv_expr_4_0= ruleExpression ) )
                    // InternalGaml.g:1879:5: (lv_expr_4_0= ruleExpression )
                    {
                    // InternalGaml.g:1879:5: (lv_expr_4_0= ruleExpression )
                    // InternalGaml.g:1880:6: lv_expr_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_ReflexAccess().getExprExpressionParserRuleCall_2_2_0());
                      					
                    }
                    pushFollow(FOLLOW_3);
                    lv_expr_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_ReflexRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_4_0,
                      							"gama.core.lang.Gaml.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalGaml.g:1898:3: ( (lv_block_5_0= ruleBlock ) )
            // InternalGaml.g:1899:4: (lv_block_5_0= ruleBlock )
            {
            // InternalGaml.g:1899:4: (lv_block_5_0= ruleBlock )
            // InternalGaml.g:1900:5: lv_block_5_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_ReflexAccess().getBlockBlockParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_block_5_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_ReflexRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_5_0,
              						"gama.core.lang.Gaml.Block");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Reflex"


    // $ANTLR start "entryRuleS_Definition"
    // InternalGaml.g:1921:1: entryRuleS_Definition returns [EObject current=null] : iv_ruleS_Definition= ruleS_Definition EOF ;
    public final EObject entryRuleS_Definition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Definition = null;


        try {
            // InternalGaml.g:1921:53: (iv_ruleS_Definition= ruleS_Definition EOF )
            // InternalGaml.g:1922:2: iv_ruleS_Definition= ruleS_Definition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_DefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Definition=ruleS_Definition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Definition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Definition"


    // $ANTLR start "ruleS_Definition"
    // InternalGaml.g:1928:1: ruleS_Definition returns [EObject current=null] : ( ( (lv_tkey_0_0= ruleTypeRef ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleActionArguments ) ) otherlv_4= ')' )? ( (lv_facets_5_0= ruleFacet ) )* ( ( (lv_block_6_0= ruleBlock ) ) | otherlv_7= ';' ) ) ;
    public final EObject ruleS_Definition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_2=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_tkey_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_1 = null;

        EObject lv_args_3_0 = null;

        EObject lv_facets_5_0 = null;

        EObject lv_block_6_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:1934:2: ( ( ( (lv_tkey_0_0= ruleTypeRef ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleActionArguments ) ) otherlv_4= ')' )? ( (lv_facets_5_0= ruleFacet ) )* ( ( (lv_block_6_0= ruleBlock ) ) | otherlv_7= ';' ) ) )
            // InternalGaml.g:1935:2: ( ( (lv_tkey_0_0= ruleTypeRef ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleActionArguments ) ) otherlv_4= ')' )? ( (lv_facets_5_0= ruleFacet ) )* ( ( (lv_block_6_0= ruleBlock ) ) | otherlv_7= ';' ) )
            {
            // InternalGaml.g:1935:2: ( ( (lv_tkey_0_0= ruleTypeRef ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleActionArguments ) ) otherlv_4= ')' )? ( (lv_facets_5_0= ruleFacet ) )* ( ( (lv_block_6_0= ruleBlock ) ) | otherlv_7= ';' ) )
            // InternalGaml.g:1936:3: ( (lv_tkey_0_0= ruleTypeRef ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) (otherlv_2= '(' ( (lv_args_3_0= ruleActionArguments ) ) otherlv_4= ')' )? ( (lv_facets_5_0= ruleFacet ) )* ( ( (lv_block_6_0= ruleBlock ) ) | otherlv_7= ';' )
            {
            // InternalGaml.g:1936:3: ( (lv_tkey_0_0= ruleTypeRef ) )
            // InternalGaml.g:1937:4: (lv_tkey_0_0= ruleTypeRef )
            {
            // InternalGaml.g:1937:4: (lv_tkey_0_0= ruleTypeRef )
            // InternalGaml.g:1938:5: lv_tkey_0_0= ruleTypeRef
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_DefinitionAccess().getTkeyTypeRefParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_tkey_0_0=ruleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_DefinitionRule());
              					}
              					set(
              						current,
              						"tkey",
              						lv_tkey_0_0,
              						"gama.core.lang.Gaml.TypeRef");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:1955:3: ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) )
            // InternalGaml.g:1956:4: ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) )
            {
            // InternalGaml.g:1956:4: ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) )
            // InternalGaml.g:1957:5: (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING )
            {
            // InternalGaml.g:1957:5: (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID||LA36_0==38||(LA36_0>=40 && LA36_0<=87)) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_STRING) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalGaml.g:1958:6: lv_name_1_1= ruleValid_ID
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_DefinitionAccess().getNameValid_IDParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_25);
                    lv_name_1_1=ruleValid_ID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_DefinitionRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_1_1,
                      							"gama.core.lang.Gaml.Valid_ID");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:1974:6: lv_name_1_2= RULE_STRING
                    {
                    lv_name_1_2=(Token)match(input,RULE_STRING,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_2, grammarAccess.getS_DefinitionAccess().getNameSTRINGTerminalRuleCall_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getS_DefinitionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_1_2,
                      							"gama.core.lang.Gaml.STRING");
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalGaml.g:1991:3: (otherlv_2= '(' ( (lv_args_3_0= ruleActionArguments ) ) otherlv_4= ')' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==31) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalGaml.g:1992:4: otherlv_2= '(' ( (lv_args_3_0= ruleActionArguments ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getS_DefinitionAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    // InternalGaml.g:1996:4: ( (lv_args_3_0= ruleActionArguments ) )
                    // InternalGaml.g:1997:5: (lv_args_3_0= ruleActionArguments )
                    {
                    // InternalGaml.g:1997:5: (lv_args_3_0= ruleActionArguments )
                    // InternalGaml.g:1998:6: lv_args_3_0= ruleActionArguments
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_DefinitionAccess().getArgsActionArgumentsParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
                    lv_args_3_0=ruleActionArguments();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_DefinitionRule());
                      						}
                      						set(
                      							current,
                      							"args",
                      							lv_args_3_0,
                      							"gama.core.lang.Gaml.ActionArguments");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,32,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getS_DefinitionAccess().getRightParenthesisKeyword_2_2());
                      			
                    }

                    }
                    break;

            }

            // InternalGaml.g:2020:3: ( (lv_facets_5_0= ruleFacet ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID||LA38_0==15||LA38_0==29||(LA38_0>=95 && LA38_0<=119)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalGaml.g:2021:4: (lv_facets_5_0= ruleFacet )
            	    {
            	    // InternalGaml.g:2021:4: (lv_facets_5_0= ruleFacet )
            	    // InternalGaml.g:2022:5: lv_facets_5_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getS_DefinitionAccess().getFacetsFacetParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_facets_5_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getS_DefinitionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_5_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            // InternalGaml.g:2039:3: ( ( (lv_block_6_0= ruleBlock ) ) | otherlv_7= ';' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==34) ) {
                alt39=1;
            }
            else if ( (LA39_0==21) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalGaml.g:2040:4: ( (lv_block_6_0= ruleBlock ) )
                    {
                    // InternalGaml.g:2040:4: ( (lv_block_6_0= ruleBlock ) )
                    // InternalGaml.g:2041:5: (lv_block_6_0= ruleBlock )
                    {
                    // InternalGaml.g:2041:5: (lv_block_6_0= ruleBlock )
                    // InternalGaml.g:2042:6: lv_block_6_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_DefinitionAccess().getBlockBlockParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_6_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_DefinitionRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_6_0,
                      							"gama.core.lang.Gaml.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:2060:4: otherlv_7= ';'
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getS_DefinitionAccess().getSemicolonKeyword_4_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Definition"


    // $ANTLR start "entryRuleS_Action"
    // InternalGaml.g:2069:1: entryRuleS_Action returns [EObject current=null] : iv_ruleS_Action= ruleS_Action EOF ;
    public final EObject entryRuleS_Action() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Action = null;


        try {
            // InternalGaml.g:2069:49: (iv_ruleS_Action= ruleS_Action EOF )
            // InternalGaml.g:2070:2: iv_ruleS_Action= ruleS_Action EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_ActionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Action=ruleS_Action();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Action; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Action"


    // $ANTLR start "ruleS_Action"
    // InternalGaml.g:2076:1: ruleS_Action returns [EObject current=null] : ( () ( (lv_key_1_0= 'action' ) ) ( (lv_name_2_0= ruleValid_ID ) ) (otherlv_3= '(' ( (lv_args_4_0= ruleActionArguments ) ) otherlv_5= ')' )? ( (lv_facets_6_0= ruleFacet ) )* ( ( (lv_block_7_0= ruleBlock ) ) | otherlv_8= ';' ) ) ;
    public final EObject ruleS_Action() throws RecognitionException {
        EObject current = null;

        Token lv_key_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_args_4_0 = null;

        EObject lv_facets_6_0 = null;

        EObject lv_block_7_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:2082:2: ( ( () ( (lv_key_1_0= 'action' ) ) ( (lv_name_2_0= ruleValid_ID ) ) (otherlv_3= '(' ( (lv_args_4_0= ruleActionArguments ) ) otherlv_5= ')' )? ( (lv_facets_6_0= ruleFacet ) )* ( ( (lv_block_7_0= ruleBlock ) ) | otherlv_8= ';' ) ) )
            // InternalGaml.g:2083:2: ( () ( (lv_key_1_0= 'action' ) ) ( (lv_name_2_0= ruleValid_ID ) ) (otherlv_3= '(' ( (lv_args_4_0= ruleActionArguments ) ) otherlv_5= ')' )? ( (lv_facets_6_0= ruleFacet ) )* ( ( (lv_block_7_0= ruleBlock ) ) | otherlv_8= ';' ) )
            {
            // InternalGaml.g:2083:2: ( () ( (lv_key_1_0= 'action' ) ) ( (lv_name_2_0= ruleValid_ID ) ) (otherlv_3= '(' ( (lv_args_4_0= ruleActionArguments ) ) otherlv_5= ')' )? ( (lv_facets_6_0= ruleFacet ) )* ( ( (lv_block_7_0= ruleBlock ) ) | otherlv_8= ';' ) )
            // InternalGaml.g:2084:3: () ( (lv_key_1_0= 'action' ) ) ( (lv_name_2_0= ruleValid_ID ) ) (otherlv_3= '(' ( (lv_args_4_0= ruleActionArguments ) ) otherlv_5= ')' )? ( (lv_facets_6_0= ruleFacet ) )* ( ( (lv_block_7_0= ruleBlock ) ) | otherlv_8= ';' )
            {
            // InternalGaml.g:2084:3: ()
            // InternalGaml.g:2085:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getS_ActionAccess().getS_ActionAction_0(),
              					current);
              			
            }

            }

            // InternalGaml.g:2091:3: ( (lv_key_1_0= 'action' ) )
            // InternalGaml.g:2092:4: (lv_key_1_0= 'action' )
            {
            // InternalGaml.g:2092:4: (lv_key_1_0= 'action' )
            // InternalGaml.g:2093:5: lv_key_1_0= 'action'
            {
            lv_key_1_0=(Token)match(input,33,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_key_1_0, grammarAccess.getS_ActionAccess().getKeyActionKeyword_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getS_ActionRule());
              					}
              					setWithLastConsumed(current, "key", lv_key_1_0, "action");
              				
            }

            }


            }

            // InternalGaml.g:2105:3: ( (lv_name_2_0= ruleValid_ID ) )
            // InternalGaml.g:2106:4: (lv_name_2_0= ruleValid_ID )
            {
            // InternalGaml.g:2106:4: (lv_name_2_0= ruleValid_ID )
            // InternalGaml.g:2107:5: lv_name_2_0= ruleValid_ID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_ActionAccess().getNameValid_IDParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_25);
            lv_name_2_0=ruleValid_ID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_ActionRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_2_0,
              						"gama.core.lang.Gaml.Valid_ID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:2124:3: (otherlv_3= '(' ( (lv_args_4_0= ruleActionArguments ) ) otherlv_5= ')' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==31) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalGaml.g:2125:4: otherlv_3= '(' ( (lv_args_4_0= ruleActionArguments ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,31,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getS_ActionAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalGaml.g:2129:4: ( (lv_args_4_0= ruleActionArguments ) )
                    // InternalGaml.g:2130:5: (lv_args_4_0= ruleActionArguments )
                    {
                    // InternalGaml.g:2130:5: (lv_args_4_0= ruleActionArguments )
                    // InternalGaml.g:2131:6: lv_args_4_0= ruleActionArguments
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_ActionAccess().getArgsActionArgumentsParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
                    lv_args_4_0=ruleActionArguments();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_ActionRule());
                      						}
                      						set(
                      							current,
                      							"args",
                      							lv_args_4_0,
                      							"gama.core.lang.Gaml.ActionArguments");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,32,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getS_ActionAccess().getRightParenthesisKeyword_3_2());
                      			
                    }

                    }
                    break;

            }

            // InternalGaml.g:2153:3: ( (lv_facets_6_0= ruleFacet ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_ID||LA41_0==15||LA41_0==29||(LA41_0>=95 && LA41_0<=119)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalGaml.g:2154:4: (lv_facets_6_0= ruleFacet )
            	    {
            	    // InternalGaml.g:2154:4: (lv_facets_6_0= ruleFacet )
            	    // InternalGaml.g:2155:5: lv_facets_6_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getS_ActionAccess().getFacetsFacetParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_facets_6_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getS_ActionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_6_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            // InternalGaml.g:2172:3: ( ( (lv_block_7_0= ruleBlock ) ) | otherlv_8= ';' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==34) ) {
                alt42=1;
            }
            else if ( (LA42_0==21) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalGaml.g:2173:4: ( (lv_block_7_0= ruleBlock ) )
                    {
                    // InternalGaml.g:2173:4: ( (lv_block_7_0= ruleBlock ) )
                    // InternalGaml.g:2174:5: (lv_block_7_0= ruleBlock )
                    {
                    // InternalGaml.g:2174:5: (lv_block_7_0= ruleBlock )
                    // InternalGaml.g:2175:6: lv_block_7_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_ActionAccess().getBlockBlockParserRuleCall_5_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_7_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_ActionRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_7_0,
                      							"gama.core.lang.Gaml.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:2193:4: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getS_ActionAccess().getSemicolonKeyword_5_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Action"


    // $ANTLR start "entryRuleS_Assignment"
    // InternalGaml.g:2202:1: entryRuleS_Assignment returns [EObject current=null] : iv_ruleS_Assignment= ruleS_Assignment EOF ;
    public final EObject entryRuleS_Assignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Assignment = null;


        try {
            // InternalGaml.g:2202:53: (iv_ruleS_Assignment= ruleS_Assignment EOF )
            // InternalGaml.g:2203:2: iv_ruleS_Assignment= ruleS_Assignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_AssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Assignment=ruleS_Assignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Assignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Assignment"


    // $ANTLR start "ruleS_Assignment"
    // InternalGaml.g:2209:1: ruleS_Assignment returns [EObject current=null] : ( ( (lv_expr_0_0= ruleExpression ) ) ( (lv_key_1_0= rule_AssignmentKey ) ) ( (lv_value_2_0= ruleExpression ) ) ( (lv_facets_3_0= ruleFacet ) )* otherlv_4= ';' ) ;
    public final EObject ruleS_Assignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        EObject lv_expr_0_0 = null;

        AntlrDatatypeRuleToken lv_key_1_0 = null;

        EObject lv_value_2_0 = null;

        EObject lv_facets_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:2215:2: ( ( ( (lv_expr_0_0= ruleExpression ) ) ( (lv_key_1_0= rule_AssignmentKey ) ) ( (lv_value_2_0= ruleExpression ) ) ( (lv_facets_3_0= ruleFacet ) )* otherlv_4= ';' ) )
            // InternalGaml.g:2216:2: ( ( (lv_expr_0_0= ruleExpression ) ) ( (lv_key_1_0= rule_AssignmentKey ) ) ( (lv_value_2_0= ruleExpression ) ) ( (lv_facets_3_0= ruleFacet ) )* otherlv_4= ';' )
            {
            // InternalGaml.g:2216:2: ( ( (lv_expr_0_0= ruleExpression ) ) ( (lv_key_1_0= rule_AssignmentKey ) ) ( (lv_value_2_0= ruleExpression ) ) ( (lv_facets_3_0= ruleFacet ) )* otherlv_4= ';' )
            // InternalGaml.g:2217:3: ( (lv_expr_0_0= ruleExpression ) ) ( (lv_key_1_0= rule_AssignmentKey ) ) ( (lv_value_2_0= ruleExpression ) ) ( (lv_facets_3_0= ruleFacet ) )* otherlv_4= ';'
            {
            // InternalGaml.g:2217:3: ( (lv_expr_0_0= ruleExpression ) )
            // InternalGaml.g:2218:4: (lv_expr_0_0= ruleExpression )
            {
            // InternalGaml.g:2218:4: (lv_expr_0_0= ruleExpression )
            // InternalGaml.g:2219:5: lv_expr_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_AssignmentAccess().getExprExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_28);
            lv_expr_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_AssignmentRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_0_0,
              						"gama.core.lang.Gaml.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:2236:3: ( (lv_key_1_0= rule_AssignmentKey ) )
            // InternalGaml.g:2237:4: (lv_key_1_0= rule_AssignmentKey )
            {
            // InternalGaml.g:2237:4: (lv_key_1_0= rule_AssignmentKey )
            // InternalGaml.g:2238:5: lv_key_1_0= rule_AssignmentKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_AssignmentAccess().getKey_AssignmentKeyParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_key_1_0=rule_AssignmentKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_AssignmentRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_1_0,
              						"gama.core.lang.Gaml._AssignmentKey");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:2255:3: ( (lv_value_2_0= ruleExpression ) )
            // InternalGaml.g:2256:4: (lv_value_2_0= ruleExpression )
            {
            // InternalGaml.g:2256:4: (lv_value_2_0= ruleExpression )
            // InternalGaml.g:2257:5: lv_value_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_AssignmentAccess().getValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_29);
            lv_value_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_AssignmentRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
              						"gama.core.lang.Gaml.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:2274:3: ( (lv_facets_3_0= ruleFacet ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_ID||LA43_0==15||LA43_0==29||(LA43_0>=95 && LA43_0<=119)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalGaml.g:2275:4: (lv_facets_3_0= ruleFacet )
            	    {
            	    // InternalGaml.g:2275:4: (lv_facets_3_0= ruleFacet )
            	    // InternalGaml.g:2276:5: lv_facets_3_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getS_AssignmentAccess().getFacetsFacetParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_facets_3_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getS_AssignmentRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_3_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            otherlv_4=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getS_AssignmentAccess().getSemicolonKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Assignment"


    // $ANTLR start "entryRuleS_Equations"
    // InternalGaml.g:2301:1: entryRuleS_Equations returns [EObject current=null] : iv_ruleS_Equations= ruleS_Equations EOF ;
    public final EObject entryRuleS_Equations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Equations = null;


        try {
            // InternalGaml.g:2301:52: (iv_ruleS_Equations= ruleS_Equations EOF )
            // InternalGaml.g:2302:2: iv_ruleS_Equations= ruleS_Equations EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_EquationsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Equations=ruleS_Equations();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Equations; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Equations"


    // $ANTLR start "ruleS_Equations"
    // InternalGaml.g:2308:1: ruleS_Equations returns [EObject current=null] : ( ( (lv_key_0_0= rule_EquationsKey ) ) ( (lv_name_1_0= ruleValid_ID ) ) ( (lv_facets_2_0= ruleFacet ) )* ( (otherlv_3= '{' ( ( (lv_equations_4_0= ruleS_Equation ) ) otherlv_5= ';' )* otherlv_6= '}' ) | otherlv_7= ';' ) ) ;
    public final EObject ruleS_Equations() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_facets_2_0 = null;

        EObject lv_equations_4_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:2314:2: ( ( ( (lv_key_0_0= rule_EquationsKey ) ) ( (lv_name_1_0= ruleValid_ID ) ) ( (lv_facets_2_0= ruleFacet ) )* ( (otherlv_3= '{' ( ( (lv_equations_4_0= ruleS_Equation ) ) otherlv_5= ';' )* otherlv_6= '}' ) | otherlv_7= ';' ) ) )
            // InternalGaml.g:2315:2: ( ( (lv_key_0_0= rule_EquationsKey ) ) ( (lv_name_1_0= ruleValid_ID ) ) ( (lv_facets_2_0= ruleFacet ) )* ( (otherlv_3= '{' ( ( (lv_equations_4_0= ruleS_Equation ) ) otherlv_5= ';' )* otherlv_6= '}' ) | otherlv_7= ';' ) )
            {
            // InternalGaml.g:2315:2: ( ( (lv_key_0_0= rule_EquationsKey ) ) ( (lv_name_1_0= ruleValid_ID ) ) ( (lv_facets_2_0= ruleFacet ) )* ( (otherlv_3= '{' ( ( (lv_equations_4_0= ruleS_Equation ) ) otherlv_5= ';' )* otherlv_6= '}' ) | otherlv_7= ';' ) )
            // InternalGaml.g:2316:3: ( (lv_key_0_0= rule_EquationsKey ) ) ( (lv_name_1_0= ruleValid_ID ) ) ( (lv_facets_2_0= ruleFacet ) )* ( (otherlv_3= '{' ( ( (lv_equations_4_0= ruleS_Equation ) ) otherlv_5= ';' )* otherlv_6= '}' ) | otherlv_7= ';' )
            {
            // InternalGaml.g:2316:3: ( (lv_key_0_0= rule_EquationsKey ) )
            // InternalGaml.g:2317:4: (lv_key_0_0= rule_EquationsKey )
            {
            // InternalGaml.g:2317:4: (lv_key_0_0= rule_EquationsKey )
            // InternalGaml.g:2318:5: lv_key_0_0= rule_EquationsKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_EquationsAccess().getKey_EquationsKeyParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_key_0_0=rule_EquationsKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_EquationsRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_0_0,
              						"gama.core.lang.Gaml._EquationsKey");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:2335:3: ( (lv_name_1_0= ruleValid_ID ) )
            // InternalGaml.g:2336:4: (lv_name_1_0= ruleValid_ID )
            {
            // InternalGaml.g:2336:4: (lv_name_1_0= ruleValid_ID )
            // InternalGaml.g:2337:5: lv_name_1_0= ruleValid_ID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_EquationsAccess().getNameValid_IDParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_name_1_0=ruleValid_ID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_EquationsRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"gama.core.lang.Gaml.Valid_ID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:2354:3: ( (lv_facets_2_0= ruleFacet ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_ID||LA44_0==15||LA44_0==29||(LA44_0>=95 && LA44_0<=119)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalGaml.g:2355:4: (lv_facets_2_0= ruleFacet )
            	    {
            	    // InternalGaml.g:2355:4: (lv_facets_2_0= ruleFacet )
            	    // InternalGaml.g:2356:5: lv_facets_2_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getS_EquationsAccess().getFacetsFacetParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_facets_2_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getS_EquationsRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_2_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            // InternalGaml.g:2373:3: ( (otherlv_3= '{' ( ( (lv_equations_4_0= ruleS_Equation ) ) otherlv_5= ';' )* otherlv_6= '}' ) | otherlv_7= ';' )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==34) ) {
                alt46=1;
            }
            else if ( (LA46_0==21) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalGaml.g:2374:4: (otherlv_3= '{' ( ( (lv_equations_4_0= ruleS_Equation ) ) otherlv_5= ';' )* otherlv_6= '}' )
                    {
                    // InternalGaml.g:2374:4: (otherlv_3= '{' ( ( (lv_equations_4_0= ruleS_Equation ) ) otherlv_5= ';' )* otherlv_6= '}' )
                    // InternalGaml.g:2375:5: otherlv_3= '{' ( ( (lv_equations_4_0= ruleS_Equation ) ) otherlv_5= ';' )* otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getS_EquationsAccess().getLeftCurlyBracketKeyword_3_0_0());
                      				
                    }
                    // InternalGaml.g:2379:5: ( ( (lv_equations_4_0= ruleS_Equation ) ) otherlv_5= ';' )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==RULE_ID||LA45_0==38||(LA45_0>=40 && LA45_0<=87)) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalGaml.g:2380:6: ( (lv_equations_4_0= ruleS_Equation ) ) otherlv_5= ';'
                    	    {
                    	    // InternalGaml.g:2380:6: ( (lv_equations_4_0= ruleS_Equation ) )
                    	    // InternalGaml.g:2381:7: (lv_equations_4_0= ruleS_Equation )
                    	    {
                    	    // InternalGaml.g:2381:7: (lv_equations_4_0= ruleS_Equation )
                    	    // InternalGaml.g:2382:8: lv_equations_4_0= ruleS_Equation
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getS_EquationsAccess().getEquationsS_EquationParserRuleCall_3_0_1_0_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_21);
                    	    lv_equations_4_0=ruleS_Equation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getS_EquationsRule());
                    	      								}
                    	      								add(
                    	      									current,
                    	      									"equations",
                    	      									lv_equations_4_0,
                    	      									"gama.core.lang.Gaml.S_Equation");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }

                    	    otherlv_5=(Token)match(input,21,FOLLOW_30); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_5, grammarAccess.getS_EquationsAccess().getSemicolonKeyword_3_0_1_1());
                    	      					
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getS_EquationsAccess().getRightCurlyBracketKeyword_3_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:2410:4: otherlv_7= ';'
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getS_EquationsAccess().getSemicolonKeyword_3_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Equations"


    // $ANTLR start "entryRuleS_Equation"
    // InternalGaml.g:2419:1: entryRuleS_Equation returns [EObject current=null] : iv_ruleS_Equation= ruleS_Equation EOF ;
    public final EObject entryRuleS_Equation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Equation = null;


        try {
            // InternalGaml.g:2419:51: (iv_ruleS_Equation= ruleS_Equation EOF )
            // InternalGaml.g:2420:2: iv_ruleS_Equation= ruleS_Equation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_EquationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Equation=ruleS_Equation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Equation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Equation"


    // $ANTLR start "ruleS_Equation"
    // InternalGaml.g:2426:1: ruleS_Equation returns [EObject current=null] : ( ( ( (lv_expr_0_1= ruleFunction | lv_expr_0_2= ruleVariableRef ) ) ) ( (lv_key_1_0= '=' ) ) ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleS_Equation() throws RecognitionException {
        EObject current = null;

        Token lv_key_1_0=null;
        EObject lv_expr_0_1 = null;

        EObject lv_expr_0_2 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:2432:2: ( ( ( ( (lv_expr_0_1= ruleFunction | lv_expr_0_2= ruleVariableRef ) ) ) ( (lv_key_1_0= '=' ) ) ( (lv_value_2_0= ruleExpression ) ) ) )
            // InternalGaml.g:2433:2: ( ( ( (lv_expr_0_1= ruleFunction | lv_expr_0_2= ruleVariableRef ) ) ) ( (lv_key_1_0= '=' ) ) ( (lv_value_2_0= ruleExpression ) ) )
            {
            // InternalGaml.g:2433:2: ( ( ( (lv_expr_0_1= ruleFunction | lv_expr_0_2= ruleVariableRef ) ) ) ( (lv_key_1_0= '=' ) ) ( (lv_value_2_0= ruleExpression ) ) )
            // InternalGaml.g:2434:3: ( ( (lv_expr_0_1= ruleFunction | lv_expr_0_2= ruleVariableRef ) ) ) ( (lv_key_1_0= '=' ) ) ( (lv_value_2_0= ruleExpression ) )
            {
            // InternalGaml.g:2434:3: ( ( (lv_expr_0_1= ruleFunction | lv_expr_0_2= ruleVariableRef ) ) )
            // InternalGaml.g:2435:4: ( (lv_expr_0_1= ruleFunction | lv_expr_0_2= ruleVariableRef ) )
            {
            // InternalGaml.g:2435:4: ( (lv_expr_0_1= ruleFunction | lv_expr_0_2= ruleVariableRef ) )
            // InternalGaml.g:2436:5: (lv_expr_0_1= ruleFunction | lv_expr_0_2= ruleVariableRef )
            {
            // InternalGaml.g:2436:5: (lv_expr_0_1= ruleFunction | lv_expr_0_2= ruleVariableRef )
            int alt47=2;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // InternalGaml.g:2437:6: lv_expr_0_1= ruleFunction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_EquationAccess().getExprFunctionParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_31);
                    lv_expr_0_1=ruleFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_EquationRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_0_1,
                      							"gama.core.lang.Gaml.Function");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:2453:6: lv_expr_0_2= ruleVariableRef
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_EquationAccess().getExprVariableRefParserRuleCall_0_0_1());
                      					
                    }
                    pushFollow(FOLLOW_31);
                    lv_expr_0_2=ruleVariableRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_EquationRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_0_2,
                      							"gama.core.lang.Gaml.VariableRef");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalGaml.g:2471:3: ( (lv_key_1_0= '=' ) )
            // InternalGaml.g:2472:4: (lv_key_1_0= '=' )
            {
            // InternalGaml.g:2472:4: (lv_key_1_0= '=' )
            // InternalGaml.g:2473:5: lv_key_1_0= '='
            {
            lv_key_1_0=(Token)match(input,36,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_key_1_0, grammarAccess.getS_EquationAccess().getKeyEqualsSignKeyword_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getS_EquationRule());
              					}
              					setWithLastConsumed(current, "key", lv_key_1_0, "=");
              				
            }

            }


            }

            // InternalGaml.g:2485:3: ( (lv_value_2_0= ruleExpression ) )
            // InternalGaml.g:2486:4: (lv_value_2_0= ruleExpression )
            {
            // InternalGaml.g:2486:4: (lv_value_2_0= ruleExpression )
            // InternalGaml.g:2487:5: lv_value_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_EquationAccess().getValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_EquationRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
              						"gama.core.lang.Gaml.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Equation"


    // $ANTLR start "entryRuleS_Solve"
    // InternalGaml.g:2508:1: entryRuleS_Solve returns [EObject current=null] : iv_ruleS_Solve= ruleS_Solve EOF ;
    public final EObject entryRuleS_Solve() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Solve = null;


        try {
            // InternalGaml.g:2508:48: (iv_ruleS_Solve= ruleS_Solve EOF )
            // InternalGaml.g:2509:2: iv_ruleS_Solve= ruleS_Solve EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_SolveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Solve=ruleS_Solve();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Solve; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Solve"


    // $ANTLR start "ruleS_Solve"
    // InternalGaml.g:2515:1: ruleS_Solve returns [EObject current=null] : ( ( (lv_key_0_0= rule_SolveKey ) ) ( (lv_expr_1_0= ruleEquationRef ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) ) ;
    public final EObject ruleS_Solve() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_expr_1_0 = null;

        EObject lv_facets_2_0 = null;

        EObject lv_block_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:2521:2: ( ( ( (lv_key_0_0= rule_SolveKey ) ) ( (lv_expr_1_0= ruleEquationRef ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) ) )
            // InternalGaml.g:2522:2: ( ( (lv_key_0_0= rule_SolveKey ) ) ( (lv_expr_1_0= ruleEquationRef ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) )
            {
            // InternalGaml.g:2522:2: ( ( (lv_key_0_0= rule_SolveKey ) ) ( (lv_expr_1_0= ruleEquationRef ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' ) )
            // InternalGaml.g:2523:3: ( (lv_key_0_0= rule_SolveKey ) ) ( (lv_expr_1_0= ruleEquationRef ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' )
            {
            // InternalGaml.g:2523:3: ( (lv_key_0_0= rule_SolveKey ) )
            // InternalGaml.g:2524:4: (lv_key_0_0= rule_SolveKey )
            {
            // InternalGaml.g:2524:4: (lv_key_0_0= rule_SolveKey )
            // InternalGaml.g:2525:5: lv_key_0_0= rule_SolveKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_SolveAccess().getKey_SolveKeyParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_key_0_0=rule_SolveKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_SolveRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_0_0,
              						"gama.core.lang.Gaml._SolveKey");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:2542:3: ( (lv_expr_1_0= ruleEquationRef ) )
            // InternalGaml.g:2543:4: (lv_expr_1_0= ruleEquationRef )
            {
            // InternalGaml.g:2543:4: (lv_expr_1_0= ruleEquationRef )
            // InternalGaml.g:2544:5: lv_expr_1_0= ruleEquationRef
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_SolveAccess().getExprEquationRefParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_expr_1_0=ruleEquationRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_SolveRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_1_0,
              						"gama.core.lang.Gaml.EquationRef");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:2561:3: ( (lv_facets_2_0= ruleFacet ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_ID||LA48_0==15||LA48_0==29||(LA48_0>=95 && LA48_0<=119)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalGaml.g:2562:4: (lv_facets_2_0= ruleFacet )
            	    {
            	    // InternalGaml.g:2562:4: (lv_facets_2_0= ruleFacet )
            	    // InternalGaml.g:2563:5: lv_facets_2_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getS_SolveAccess().getFacetsFacetParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_facets_2_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getS_SolveRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_2_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            // InternalGaml.g:2580:3: ( ( (lv_block_3_0= ruleBlock ) ) | otherlv_4= ';' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==34) ) {
                alt49=1;
            }
            else if ( (LA49_0==21) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalGaml.g:2581:4: ( (lv_block_3_0= ruleBlock ) )
                    {
                    // InternalGaml.g:2581:4: ( (lv_block_3_0= ruleBlock ) )
                    // InternalGaml.g:2582:5: (lv_block_3_0= ruleBlock )
                    {
                    // InternalGaml.g:2582:5: (lv_block_3_0= ruleBlock )
                    // InternalGaml.g:2583:6: lv_block_3_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_SolveAccess().getBlockBlockParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_3_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_SolveRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_3_0,
                      							"gama.core.lang.Gaml.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:2601:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getS_SolveAccess().getSemicolonKeyword_3_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Solve"


    // $ANTLR start "entryRuleS_Display"
    // InternalGaml.g:2610:1: entryRuleS_Display returns [EObject current=null] : iv_ruleS_Display= ruleS_Display EOF ;
    public final EObject entryRuleS_Display() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleS_Display = null;


        try {
            // InternalGaml.g:2610:50: (iv_ruleS_Display= ruleS_Display EOF )
            // InternalGaml.g:2611:2: iv_ruleS_Display= ruleS_Display EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getS_DisplayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleS_Display=ruleS_Display();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleS_Display; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleS_Display"


    // $ANTLR start "ruleS_Display"
    // InternalGaml.g:2617:1: ruleS_Display returns [EObject current=null] : ( ( (lv_key_0_0= 'display' ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) ( (lv_facets_2_0= ruleFacet ) )* ( (lv_block_3_0= ruledisplayBlock ) ) ) ;
    public final EObject ruleS_Display() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token lv_name_1_2=null;
        AntlrDatatypeRuleToken lv_name_1_1 = null;

        EObject lv_facets_2_0 = null;

        EObject lv_block_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:2623:2: ( ( ( (lv_key_0_0= 'display' ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) ( (lv_facets_2_0= ruleFacet ) )* ( (lv_block_3_0= ruledisplayBlock ) ) ) )
            // InternalGaml.g:2624:2: ( ( (lv_key_0_0= 'display' ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) ( (lv_facets_2_0= ruleFacet ) )* ( (lv_block_3_0= ruledisplayBlock ) ) )
            {
            // InternalGaml.g:2624:2: ( ( (lv_key_0_0= 'display' ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) ( (lv_facets_2_0= ruleFacet ) )* ( (lv_block_3_0= ruledisplayBlock ) ) )
            // InternalGaml.g:2625:3: ( (lv_key_0_0= 'display' ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) ( (lv_facets_2_0= ruleFacet ) )* ( (lv_block_3_0= ruledisplayBlock ) )
            {
            // InternalGaml.g:2625:3: ( (lv_key_0_0= 'display' ) )
            // InternalGaml.g:2626:4: (lv_key_0_0= 'display' )
            {
            // InternalGaml.g:2626:4: (lv_key_0_0= 'display' )
            // InternalGaml.g:2627:5: lv_key_0_0= 'display'
            {
            lv_key_0_0=(Token)match(input,37,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_key_0_0, grammarAccess.getS_DisplayAccess().getKeyDisplayKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getS_DisplayRule());
              					}
              					setWithLastConsumed(current, "key", lv_key_0_0, "display");
              				
            }

            }


            }

            // InternalGaml.g:2639:3: ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) )
            // InternalGaml.g:2640:4: ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) )
            {
            // InternalGaml.g:2640:4: ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) )
            // InternalGaml.g:2641:5: (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING )
            {
            // InternalGaml.g:2641:5: (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID||LA50_0==38||(LA50_0>=40 && LA50_0<=87)) ) {
                alt50=1;
            }
            else if ( (LA50_0==RULE_STRING) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalGaml.g:2642:6: lv_name_1_1= ruleValid_ID
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getS_DisplayAccess().getNameValid_IDParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_16);
                    lv_name_1_1=ruleValid_ID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getS_DisplayRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_1_1,
                      							"gama.core.lang.Gaml.Valid_ID");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:2658:6: lv_name_1_2= RULE_STRING
                    {
                    lv_name_1_2=(Token)match(input,RULE_STRING,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_2, grammarAccess.getS_DisplayAccess().getNameSTRINGTerminalRuleCall_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getS_DisplayRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_1_2,
                      							"gama.core.lang.Gaml.STRING");
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalGaml.g:2675:3: ( (lv_facets_2_0= ruleFacet ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_ID||LA51_0==15||LA51_0==29||(LA51_0>=95 && LA51_0<=119)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalGaml.g:2676:4: (lv_facets_2_0= ruleFacet )
            	    {
            	    // InternalGaml.g:2676:4: (lv_facets_2_0= ruleFacet )
            	    // InternalGaml.g:2677:5: lv_facets_2_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getS_DisplayAccess().getFacetsFacetParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_facets_2_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getS_DisplayRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_2_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            // InternalGaml.g:2694:3: ( (lv_block_3_0= ruledisplayBlock ) )
            // InternalGaml.g:2695:4: (lv_block_3_0= ruledisplayBlock )
            {
            // InternalGaml.g:2695:4: (lv_block_3_0= ruledisplayBlock )
            // InternalGaml.g:2696:5: lv_block_3_0= ruledisplayBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getS_DisplayAccess().getBlockDisplayBlockParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_block_3_0=ruledisplayBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getS_DisplayRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_3_0,
              						"gama.core.lang.Gaml.displayBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleS_Display"


    // $ANTLR start "entryRuledisplayBlock"
    // InternalGaml.g:2717:1: entryRuledisplayBlock returns [EObject current=null] : iv_ruledisplayBlock= ruledisplayBlock EOF ;
    public final EObject entryRuledisplayBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruledisplayBlock = null;


        try {
            // InternalGaml.g:2717:53: (iv_ruledisplayBlock= ruledisplayBlock EOF )
            // InternalGaml.g:2718:2: iv_ruledisplayBlock= ruledisplayBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDisplayBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruledisplayBlock=ruledisplayBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruledisplayBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuledisplayBlock"


    // $ANTLR start "ruledisplayBlock"
    // InternalGaml.g:2724:1: ruledisplayBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruledisplayStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruledisplayBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:2730:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruledisplayStatement ) )* otherlv_3= '}' ) )
            // InternalGaml.g:2731:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruledisplayStatement ) )* otherlv_3= '}' )
            {
            // InternalGaml.g:2731:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruledisplayStatement ) )* otherlv_3= '}' )
            // InternalGaml.g:2732:3: () otherlv_1= '{' ( (lv_statements_2_0= ruledisplayStatement ) )* otherlv_3= '}'
            {
            // InternalGaml.g:2732:3: ()
            // InternalGaml.g:2733:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDisplayBlockAccess().getBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,34,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDisplayBlockAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalGaml.g:2743:3: ( (lv_statements_2_0= ruledisplayStatement ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=40 && LA52_0<=41)||(LA52_0>=43 && LA52_0<=82)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalGaml.g:2744:4: (lv_statements_2_0= ruledisplayStatement )
            	    {
            	    // InternalGaml.g:2744:4: (lv_statements_2_0= ruledisplayStatement )
            	    // InternalGaml.g:2745:5: lv_statements_2_0= ruledisplayStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDisplayBlockAccess().getStatementsDisplayStatementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_statements_2_0=ruledisplayStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getDisplayBlockRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_2_0,
            	      						"gama.core.lang.Gaml.displayStatement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            otherlv_3=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getDisplayBlockAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruledisplayBlock"


    // $ANTLR start "entryRuledisplayStatement"
    // InternalGaml.g:2770:1: entryRuledisplayStatement returns [EObject current=null] : iv_ruledisplayStatement= ruledisplayStatement EOF ;
    public final EObject entryRuledisplayStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruledisplayStatement = null;


        try {
            // InternalGaml.g:2770:57: (iv_ruledisplayStatement= ruledisplayStatement EOF )
            // InternalGaml.g:2771:2: iv_ruledisplayStatement= ruledisplayStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDisplayStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruledisplayStatement=ruledisplayStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruledisplayStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuledisplayStatement"


    // $ANTLR start "ruledisplayStatement"
    // InternalGaml.g:2777:1: ruledisplayStatement returns [EObject current=null] : (this_speciesOrGridDisplayStatement_0= rulespeciesOrGridDisplayStatement | this_S_1Expr_Facets_BlockOrEnd_1= ruleS_1Expr_Facets_BlockOrEnd ) ;
    public final EObject ruledisplayStatement() throws RecognitionException {
        EObject current = null;

        EObject this_speciesOrGridDisplayStatement_0 = null;

        EObject this_S_1Expr_Facets_BlockOrEnd_1 = null;



        	enterRule();

        try {
            // InternalGaml.g:2783:2: ( (this_speciesOrGridDisplayStatement_0= rulespeciesOrGridDisplayStatement | this_S_1Expr_Facets_BlockOrEnd_1= ruleS_1Expr_Facets_BlockOrEnd ) )
            // InternalGaml.g:2784:2: (this_speciesOrGridDisplayStatement_0= rulespeciesOrGridDisplayStatement | this_S_1Expr_Facets_BlockOrEnd_1= ruleS_1Expr_Facets_BlockOrEnd )
            {
            // InternalGaml.g:2784:2: (this_speciesOrGridDisplayStatement_0= rulespeciesOrGridDisplayStatement | this_S_1Expr_Facets_BlockOrEnd_1= ruleS_1Expr_Facets_BlockOrEnd )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=40 && LA53_0<=41)) ) {
                alt53=1;
            }
            else if ( ((LA53_0>=43 && LA53_0<=82)) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalGaml.g:2785:3: this_speciesOrGridDisplayStatement_0= rulespeciesOrGridDisplayStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDisplayStatementAccess().getSpeciesOrGridDisplayStatementParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_speciesOrGridDisplayStatement_0=rulespeciesOrGridDisplayStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_speciesOrGridDisplayStatement_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:2794:3: this_S_1Expr_Facets_BlockOrEnd_1= ruleS_1Expr_Facets_BlockOrEnd
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDisplayStatementAccess().getS_1Expr_Facets_BlockOrEndParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_S_1Expr_Facets_BlockOrEnd_1=ruleS_1Expr_Facets_BlockOrEnd();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_S_1Expr_Facets_BlockOrEnd_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruledisplayStatement"


    // $ANTLR start "entryRulespeciesOrGridDisplayStatement"
    // InternalGaml.g:2806:1: entryRulespeciesOrGridDisplayStatement returns [EObject current=null] : iv_rulespeciesOrGridDisplayStatement= rulespeciesOrGridDisplayStatement EOF ;
    public final EObject entryRulespeciesOrGridDisplayStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulespeciesOrGridDisplayStatement = null;


        try {
            // InternalGaml.g:2806:70: (iv_rulespeciesOrGridDisplayStatement= rulespeciesOrGridDisplayStatement EOF )
            // InternalGaml.g:2807:2: iv_rulespeciesOrGridDisplayStatement= rulespeciesOrGridDisplayStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpeciesOrGridDisplayStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulespeciesOrGridDisplayStatement=rulespeciesOrGridDisplayStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulespeciesOrGridDisplayStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulespeciesOrGridDisplayStatement"


    // $ANTLR start "rulespeciesOrGridDisplayStatement"
    // InternalGaml.g:2813:1: rulespeciesOrGridDisplayStatement returns [EObject current=null] : ( ( (lv_key_0_0= rule_SpeciesKey ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruledisplayBlock ) ) | otherlv_4= ';' ) ) ;
    public final EObject rulespeciesOrGridDisplayStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_expr_1_0 = null;

        EObject lv_facets_2_0 = null;

        EObject lv_block_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:2819:2: ( ( ( (lv_key_0_0= rule_SpeciesKey ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruledisplayBlock ) ) | otherlv_4= ';' ) ) )
            // InternalGaml.g:2820:2: ( ( (lv_key_0_0= rule_SpeciesKey ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruledisplayBlock ) ) | otherlv_4= ';' ) )
            {
            // InternalGaml.g:2820:2: ( ( (lv_key_0_0= rule_SpeciesKey ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruledisplayBlock ) ) | otherlv_4= ';' ) )
            // InternalGaml.g:2821:3: ( (lv_key_0_0= rule_SpeciesKey ) ) ( (lv_expr_1_0= ruleExpression ) ) ( (lv_facets_2_0= ruleFacet ) )* ( ( (lv_block_3_0= ruledisplayBlock ) ) | otherlv_4= ';' )
            {
            // InternalGaml.g:2821:3: ( (lv_key_0_0= rule_SpeciesKey ) )
            // InternalGaml.g:2822:4: (lv_key_0_0= rule_SpeciesKey )
            {
            // InternalGaml.g:2822:4: (lv_key_0_0= rule_SpeciesKey )
            // InternalGaml.g:2823:5: lv_key_0_0= rule_SpeciesKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSpeciesOrGridDisplayStatementAccess().getKey_SpeciesKeyParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_key_0_0=rule_SpeciesKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSpeciesOrGridDisplayStatementRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_0_0,
              						"gama.core.lang.Gaml._SpeciesKey");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:2840:3: ( (lv_expr_1_0= ruleExpression ) )
            // InternalGaml.g:2841:4: (lv_expr_1_0= ruleExpression )
            {
            // InternalGaml.g:2841:4: (lv_expr_1_0= ruleExpression )
            // InternalGaml.g:2842:5: lv_expr_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSpeciesOrGridDisplayStatementAccess().getExprExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_expr_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSpeciesOrGridDisplayStatementRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_1_0,
              						"gama.core.lang.Gaml.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:2859:3: ( (lv_facets_2_0= ruleFacet ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ID||LA54_0==15||LA54_0==29||(LA54_0>=95 && LA54_0<=119)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalGaml.g:2860:4: (lv_facets_2_0= ruleFacet )
            	    {
            	    // InternalGaml.g:2860:4: (lv_facets_2_0= ruleFacet )
            	    // InternalGaml.g:2861:5: lv_facets_2_0= ruleFacet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSpeciesOrGridDisplayStatementAccess().getFacetsFacetParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_facets_2_0=ruleFacet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSpeciesOrGridDisplayStatementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"facets",
            	      						lv_facets_2_0,
            	      						"gama.core.lang.Gaml.Facet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            // InternalGaml.g:2878:3: ( ( (lv_block_3_0= ruledisplayBlock ) ) | otherlv_4= ';' )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==34) ) {
                alt55=1;
            }
            else if ( (LA55_0==21) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalGaml.g:2879:4: ( (lv_block_3_0= ruledisplayBlock ) )
                    {
                    // InternalGaml.g:2879:4: ( (lv_block_3_0= ruledisplayBlock ) )
                    // InternalGaml.g:2880:5: (lv_block_3_0= ruledisplayBlock )
                    {
                    // InternalGaml.g:2880:5: (lv_block_3_0= ruledisplayBlock )
                    // InternalGaml.g:2881:6: lv_block_3_0= ruledisplayBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSpeciesOrGridDisplayStatementAccess().getBlockDisplayBlockParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_3_0=ruledisplayBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSpeciesOrGridDisplayStatementRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_3_0,
                      							"gama.core.lang.Gaml.displayBlock");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:2899:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getSpeciesOrGridDisplayStatementAccess().getSemicolonKeyword_3_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulespeciesOrGridDisplayStatement"


    // $ANTLR start "entryRule_EquationsKey"
    // InternalGaml.g:2908:1: entryRule_EquationsKey returns [String current=null] : iv_rule_EquationsKey= rule_EquationsKey EOF ;
    public final String entryRule_EquationsKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rule_EquationsKey = null;


        try {
            // InternalGaml.g:2908:53: (iv_rule_EquationsKey= rule_EquationsKey EOF )
            // InternalGaml.g:2909:2: iv_rule_EquationsKey= rule_EquationsKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.get_EquationsKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rule_EquationsKey=rule_EquationsKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rule_EquationsKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRule_EquationsKey"


    // $ANTLR start "rule_EquationsKey"
    // InternalGaml.g:2915:1: rule_EquationsKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'equation' ;
    public final AntlrDatatypeRuleToken rule_EquationsKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGaml.g:2921:2: (kw= 'equation' )
            // InternalGaml.g:2922:2: kw= 'equation'
            {
            kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.get_EquationsKeyAccess().getEquationKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rule_EquationsKey"


    // $ANTLR start "entryRule_SolveKey"
    // InternalGaml.g:2930:1: entryRule_SolveKey returns [String current=null] : iv_rule_SolveKey= rule_SolveKey EOF ;
    public final String entryRule_SolveKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rule_SolveKey = null;


        try {
            // InternalGaml.g:2930:49: (iv_rule_SolveKey= rule_SolveKey EOF )
            // InternalGaml.g:2931:2: iv_rule_SolveKey= rule_SolveKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.get_SolveKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rule_SolveKey=rule_SolveKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rule_SolveKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRule_SolveKey"


    // $ANTLR start "rule_SolveKey"
    // InternalGaml.g:2937:1: rule_SolveKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'solve' ;
    public final AntlrDatatypeRuleToken rule_SolveKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGaml.g:2943:2: (kw= 'solve' )
            // InternalGaml.g:2944:2: kw= 'solve'
            {
            kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.get_SolveKeyAccess().getSolveKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rule_SolveKey"


    // $ANTLR start "entryRule_SpeciesKey"
    // InternalGaml.g:2952:1: entryRule_SpeciesKey returns [String current=null] : iv_rule_SpeciesKey= rule_SpeciesKey EOF ;
    public final String entryRule_SpeciesKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rule_SpeciesKey = null;


        try {
            // InternalGaml.g:2952:51: (iv_rule_SpeciesKey= rule_SpeciesKey EOF )
            // InternalGaml.g:2953:2: iv_rule_SpeciesKey= rule_SpeciesKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.get_SpeciesKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rule_SpeciesKey=rule_SpeciesKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rule_SpeciesKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRule_SpeciesKey"


    // $ANTLR start "rule_SpeciesKey"
    // InternalGaml.g:2959:1: rule_SpeciesKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'species' | kw= 'grid' ) ;
    public final AntlrDatatypeRuleToken rule_SpeciesKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGaml.g:2965:2: ( (kw= 'species' | kw= 'grid' ) )
            // InternalGaml.g:2966:2: (kw= 'species' | kw= 'grid' )
            {
            // InternalGaml.g:2966:2: (kw= 'species' | kw= 'grid' )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==40) ) {
                alt56=1;
            }
            else if ( (LA56_0==41) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalGaml.g:2967:3: kw= 'species'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_SpeciesKeyAccess().getSpeciesKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:2973:3: kw= 'grid'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_SpeciesKeyAccess().getGridKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rule_SpeciesKey"


    // $ANTLR start "entryRule_ExperimentKey"
    // InternalGaml.g:2982:1: entryRule_ExperimentKey returns [String current=null] : iv_rule_ExperimentKey= rule_ExperimentKey EOF ;
    public final String entryRule_ExperimentKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rule_ExperimentKey = null;


        try {
            // InternalGaml.g:2982:54: (iv_rule_ExperimentKey= rule_ExperimentKey EOF )
            // InternalGaml.g:2983:2: iv_rule_ExperimentKey= rule_ExperimentKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.get_ExperimentKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rule_ExperimentKey=rule_ExperimentKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rule_ExperimentKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRule_ExperimentKey"


    // $ANTLR start "rule_ExperimentKey"
    // InternalGaml.g:2989:1: rule_ExperimentKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'experiment' ;
    public final AntlrDatatypeRuleToken rule_ExperimentKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGaml.g:2995:2: (kw= 'experiment' )
            // InternalGaml.g:2996:2: kw= 'experiment'
            {
            kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.get_ExperimentKeyAccess().getExperimentKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rule_ExperimentKey"


    // $ANTLR start "entryRule_1Expr_Facets_BlockOrEnd_Key"
    // InternalGaml.g:3004:1: entryRule_1Expr_Facets_BlockOrEnd_Key returns [String current=null] : iv_rule_1Expr_Facets_BlockOrEnd_Key= rule_1Expr_Facets_BlockOrEnd_Key EOF ;
    public final String entryRule_1Expr_Facets_BlockOrEnd_Key() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rule_1Expr_Facets_BlockOrEnd_Key = null;


        try {
            // InternalGaml.g:3004:68: (iv_rule_1Expr_Facets_BlockOrEnd_Key= rule_1Expr_Facets_BlockOrEnd_Key EOF )
            // InternalGaml.g:3005:2: iv_rule_1Expr_Facets_BlockOrEnd_Key= rule_1Expr_Facets_BlockOrEnd_Key EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rule_1Expr_Facets_BlockOrEnd_Key=rule_1Expr_Facets_BlockOrEnd_Key();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rule_1Expr_Facets_BlockOrEnd_Key.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRule_1Expr_Facets_BlockOrEnd_Key"


    // $ANTLR start "rule_1Expr_Facets_BlockOrEnd_Key"
    // InternalGaml.g:3011:1: rule_1Expr_Facets_BlockOrEnd_Key returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this__LayerKey_0= rule_LayerKey | kw= 'ask' | kw= 'release' | kw= 'capture' | kw= 'create' | kw= 'write' | kw= 'error' | kw= 'warn' | kw= 'exception' | kw= 'save' | kw= 'assert' | kw= 'inspect' | kw= 'browse' | kw= 'draw' | kw= 'using' | kw= 'switch' | kw= 'put' | kw= 'add' | kw= 'remove' | kw= 'match' | kw= 'match_between' | kw= 'match_one' | kw= 'parameter' | kw= 'status' | kw= 'highlight' | kw= 'focus_on' | kw= 'layout' ) ;
    public final AntlrDatatypeRuleToken rule_1Expr_Facets_BlockOrEnd_Key() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this__LayerKey_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:3017:2: ( (this__LayerKey_0= rule_LayerKey | kw= 'ask' | kw= 'release' | kw= 'capture' | kw= 'create' | kw= 'write' | kw= 'error' | kw= 'warn' | kw= 'exception' | kw= 'save' | kw= 'assert' | kw= 'inspect' | kw= 'browse' | kw= 'draw' | kw= 'using' | kw= 'switch' | kw= 'put' | kw= 'add' | kw= 'remove' | kw= 'match' | kw= 'match_between' | kw= 'match_one' | kw= 'parameter' | kw= 'status' | kw= 'highlight' | kw= 'focus_on' | kw= 'layout' ) )
            // InternalGaml.g:3018:2: (this__LayerKey_0= rule_LayerKey | kw= 'ask' | kw= 'release' | kw= 'capture' | kw= 'create' | kw= 'write' | kw= 'error' | kw= 'warn' | kw= 'exception' | kw= 'save' | kw= 'assert' | kw= 'inspect' | kw= 'browse' | kw= 'draw' | kw= 'using' | kw= 'switch' | kw= 'put' | kw= 'add' | kw= 'remove' | kw= 'match' | kw= 'match_between' | kw= 'match_one' | kw= 'parameter' | kw= 'status' | kw= 'highlight' | kw= 'focus_on' | kw= 'layout' )
            {
            // InternalGaml.g:3018:2: (this__LayerKey_0= rule_LayerKey | kw= 'ask' | kw= 'release' | kw= 'capture' | kw= 'create' | kw= 'write' | kw= 'error' | kw= 'warn' | kw= 'exception' | kw= 'save' | kw= 'assert' | kw= 'inspect' | kw= 'browse' | kw= 'draw' | kw= 'using' | kw= 'switch' | kw= 'put' | kw= 'add' | kw= 'remove' | kw= 'match' | kw= 'match_between' | kw= 'match_one' | kw= 'parameter' | kw= 'status' | kw= 'highlight' | kw= 'focus_on' | kw= 'layout' )
            int alt57=27;
            switch ( input.LA(1) ) {
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
                {
                alt57=1;
                }
                break;
            case 43:
                {
                alt57=2;
                }
                break;
            case 44:
                {
                alt57=3;
                }
                break;
            case 45:
                {
                alt57=4;
                }
                break;
            case 46:
                {
                alt57=5;
                }
                break;
            case 47:
                {
                alt57=6;
                }
                break;
            case 48:
                {
                alt57=7;
                }
                break;
            case 49:
                {
                alt57=8;
                }
                break;
            case 50:
                {
                alt57=9;
                }
                break;
            case 51:
                {
                alt57=10;
                }
                break;
            case 52:
                {
                alt57=11;
                }
                break;
            case 53:
                {
                alt57=12;
                }
                break;
            case 54:
                {
                alt57=13;
                }
                break;
            case 55:
                {
                alt57=14;
                }
                break;
            case 56:
                {
                alt57=15;
                }
                break;
            case 57:
                {
                alt57=16;
                }
                break;
            case 58:
                {
                alt57=17;
                }
                break;
            case 59:
                {
                alt57=18;
                }
                break;
            case 60:
                {
                alt57=19;
                }
                break;
            case 61:
                {
                alt57=20;
                }
                break;
            case 62:
                {
                alt57=21;
                }
                break;
            case 63:
                {
                alt57=22;
                }
                break;
            case 64:
                {
                alt57=23;
                }
                break;
            case 65:
                {
                alt57=24;
                }
                break;
            case 66:
                {
                alt57=25;
                }
                break;
            case 67:
                {
                alt57=26;
                }
                break;
            case 68:
                {
                alt57=27;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalGaml.g:3019:3: this__LayerKey_0= rule_LayerKey
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().get_LayerKeyParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this__LayerKey_0=rule_LayerKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this__LayerKey_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:3030:3: kw= 'ask'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getAskKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGaml.g:3036:3: kw= 'release'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getReleaseKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalGaml.g:3042:3: kw= 'capture'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getCaptureKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalGaml.g:3048:3: kw= 'create'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getCreateKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalGaml.g:3054:3: kw= 'write'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getWriteKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalGaml.g:3060:3: kw= 'error'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getErrorKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalGaml.g:3066:3: kw= 'warn'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getWarnKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalGaml.g:3072:3: kw= 'exception'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getExceptionKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalGaml.g:3078:3: kw= 'save'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getSaveKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalGaml.g:3084:3: kw= 'assert'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getAssertKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalGaml.g:3090:3: kw= 'inspect'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getInspectKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalGaml.g:3096:3: kw= 'browse'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getBrowseKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalGaml.g:3102:3: kw= 'draw'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getDrawKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalGaml.g:3108:3: kw= 'using'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getUsingKeyword_14());
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalGaml.g:3114:3: kw= 'switch'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getSwitchKeyword_15());
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalGaml.g:3120:3: kw= 'put'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getPutKeyword_16());
                      		
                    }

                    }
                    break;
                case 18 :
                    // InternalGaml.g:3126:3: kw= 'add'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getAddKeyword_17());
                      		
                    }

                    }
                    break;
                case 19 :
                    // InternalGaml.g:3132:3: kw= 'remove'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getRemoveKeyword_18());
                      		
                    }

                    }
                    break;
                case 20 :
                    // InternalGaml.g:3138:3: kw= 'match'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getMatchKeyword_19());
                      		
                    }

                    }
                    break;
                case 21 :
                    // InternalGaml.g:3144:3: kw= 'match_between'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getMatch_betweenKeyword_20());
                      		
                    }

                    }
                    break;
                case 22 :
                    // InternalGaml.g:3150:3: kw= 'match_one'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getMatch_oneKeyword_21());
                      		
                    }

                    }
                    break;
                case 23 :
                    // InternalGaml.g:3156:3: kw= 'parameter'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getParameterKeyword_22());
                      		
                    }

                    }
                    break;
                case 24 :
                    // InternalGaml.g:3162:3: kw= 'status'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getStatusKeyword_23());
                      		
                    }

                    }
                    break;
                case 25 :
                    // InternalGaml.g:3168:3: kw= 'highlight'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getHighlightKeyword_24());
                      		
                    }

                    }
                    break;
                case 26 :
                    // InternalGaml.g:3174:3: kw= 'focus_on'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getFocus_onKeyword_25());
                      		
                    }

                    }
                    break;
                case 27 :
                    // InternalGaml.g:3180:3: kw= 'layout'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_1Expr_Facets_BlockOrEnd_KeyAccess().getLayoutKeyword_26());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rule_1Expr_Facets_BlockOrEnd_Key"


    // $ANTLR start "entryRule_LayerKey"
    // InternalGaml.g:3189:1: entryRule_LayerKey returns [String current=null] : iv_rule_LayerKey= rule_LayerKey EOF ;
    public final String entryRule_LayerKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rule_LayerKey = null;


        try {
            // InternalGaml.g:3189:49: (iv_rule_LayerKey= rule_LayerKey EOF )
            // InternalGaml.g:3190:2: iv_rule_LayerKey= rule_LayerKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.get_LayerKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rule_LayerKey=rule_LayerKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rule_LayerKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRule_LayerKey"


    // $ANTLR start "rule_LayerKey"
    // InternalGaml.g:3196:1: rule_LayerKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'light' | kw= 'camera' | kw= 'text' | kw= 'image' | kw= 'data' | kw= 'chart' | kw= 'agents' | kw= 'graphics' | kw= 'display_population' | kw= 'display_grid' | kw= 'quadtree' | kw= 'event' | kw= 'overlay' | kw= 'datalist' ) ;
    public final AntlrDatatypeRuleToken rule_LayerKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGaml.g:3202:2: ( (kw= 'light' | kw= 'camera' | kw= 'text' | kw= 'image' | kw= 'data' | kw= 'chart' | kw= 'agents' | kw= 'graphics' | kw= 'display_population' | kw= 'display_grid' | kw= 'quadtree' | kw= 'event' | kw= 'overlay' | kw= 'datalist' ) )
            // InternalGaml.g:3203:2: (kw= 'light' | kw= 'camera' | kw= 'text' | kw= 'image' | kw= 'data' | kw= 'chart' | kw= 'agents' | kw= 'graphics' | kw= 'display_population' | kw= 'display_grid' | kw= 'quadtree' | kw= 'event' | kw= 'overlay' | kw= 'datalist' )
            {
            // InternalGaml.g:3203:2: (kw= 'light' | kw= 'camera' | kw= 'text' | kw= 'image' | kw= 'data' | kw= 'chart' | kw= 'agents' | kw= 'graphics' | kw= 'display_population' | kw= 'display_grid' | kw= 'quadtree' | kw= 'event' | kw= 'overlay' | kw= 'datalist' )
            int alt58=14;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt58=1;
                }
                break;
            case 70:
                {
                alt58=2;
                }
                break;
            case 71:
                {
                alt58=3;
                }
                break;
            case 72:
                {
                alt58=4;
                }
                break;
            case 73:
                {
                alt58=5;
                }
                break;
            case 74:
                {
                alt58=6;
                }
                break;
            case 75:
                {
                alt58=7;
                }
                break;
            case 76:
                {
                alt58=8;
                }
                break;
            case 77:
                {
                alt58=9;
                }
                break;
            case 78:
                {
                alt58=10;
                }
                break;
            case 79:
                {
                alt58=11;
                }
                break;
            case 80:
                {
                alt58=12;
                }
                break;
            case 81:
                {
                alt58=13;
                }
                break;
            case 82:
                {
                alt58=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalGaml.g:3204:3: kw= 'light'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getLightKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:3210:3: kw= 'camera'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getCameraKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGaml.g:3216:3: kw= 'text'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getTextKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalGaml.g:3222:3: kw= 'image'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getImageKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalGaml.g:3228:3: kw= 'data'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getDataKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalGaml.g:3234:3: kw= 'chart'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getChartKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalGaml.g:3240:3: kw= 'agents'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getAgentsKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalGaml.g:3246:3: kw= 'graphics'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getGraphicsKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalGaml.g:3252:3: kw= 'display_population'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getDisplay_populationKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalGaml.g:3258:3: kw= 'display_grid'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getDisplay_gridKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalGaml.g:3264:3: kw= 'quadtree'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getQuadtreeKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalGaml.g:3270:3: kw= 'event'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getEventKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalGaml.g:3276:3: kw= 'overlay'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getOverlayKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalGaml.g:3282:3: kw= 'datalist'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_LayerKeyAccess().getDatalistKeyword_13());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rule_LayerKey"


    // $ANTLR start "entryRule_DoKey"
    // InternalGaml.g:3291:1: entryRule_DoKey returns [String current=null] : iv_rule_DoKey= rule_DoKey EOF ;
    public final String entryRule_DoKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rule_DoKey = null;


        try {
            // InternalGaml.g:3291:46: (iv_rule_DoKey= rule_DoKey EOF )
            // InternalGaml.g:3292:2: iv_rule_DoKey= rule_DoKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.get_DoKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rule_DoKey=rule_DoKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rule_DoKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRule_DoKey"


    // $ANTLR start "rule_DoKey"
    // InternalGaml.g:3298:1: rule_DoKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'do' | kw= 'invoke' ) ;
    public final AntlrDatatypeRuleToken rule_DoKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGaml.g:3304:2: ( (kw= 'do' | kw= 'invoke' ) )
            // InternalGaml.g:3305:2: (kw= 'do' | kw= 'invoke' )
            {
            // InternalGaml.g:3305:2: (kw= 'do' | kw= 'invoke' )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==83) ) {
                alt59=1;
            }
            else if ( (LA59_0==84) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalGaml.g:3306:3: kw= 'do'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_DoKeyAccess().getDoKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:3312:3: kw= 'invoke'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_DoKeyAccess().getInvokeKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rule_DoKey"


    // $ANTLR start "entryRule_ReflexKey"
    // InternalGaml.g:3321:1: entryRule_ReflexKey returns [String current=null] : iv_rule_ReflexKey= rule_ReflexKey EOF ;
    public final String entryRule_ReflexKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rule_ReflexKey = null;


        try {
            // InternalGaml.g:3321:50: (iv_rule_ReflexKey= rule_ReflexKey EOF )
            // InternalGaml.g:3322:2: iv_rule_ReflexKey= rule_ReflexKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.get_ReflexKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rule_ReflexKey=rule_ReflexKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rule_ReflexKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRule_ReflexKey"


    // $ANTLR start "rule_ReflexKey"
    // InternalGaml.g:3328:1: rule_ReflexKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'init' | kw= 'reflex' | kw= 'aspect' ) ;
    public final AntlrDatatypeRuleToken rule_ReflexKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGaml.g:3334:2: ( (kw= 'init' | kw= 'reflex' | kw= 'aspect' ) )
            // InternalGaml.g:3335:2: (kw= 'init' | kw= 'reflex' | kw= 'aspect' )
            {
            // InternalGaml.g:3335:2: (kw= 'init' | kw= 'reflex' | kw= 'aspect' )
            int alt60=3;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt60=1;
                }
                break;
            case 86:
                {
                alt60=2;
                }
                break;
            case 87:
                {
                alt60=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // InternalGaml.g:3336:3: kw= 'init'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_ReflexKeyAccess().getInitKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:3342:3: kw= 'reflex'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_ReflexKeyAccess().getReflexKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGaml.g:3348:3: kw= 'aspect'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_ReflexKeyAccess().getAspectKeyword_2());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rule_ReflexKey"


    // $ANTLR start "entryRule_AssignmentKey"
    // InternalGaml.g:3357:1: entryRule_AssignmentKey returns [String current=null] : iv_rule_AssignmentKey= rule_AssignmentKey EOF ;
    public final String entryRule_AssignmentKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rule_AssignmentKey = null;


        try {
            // InternalGaml.g:3357:54: (iv_rule_AssignmentKey= rule_AssignmentKey EOF )
            // InternalGaml.g:3358:2: iv_rule_AssignmentKey= rule_AssignmentKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.get_AssignmentKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rule_AssignmentKey=rule_AssignmentKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rule_AssignmentKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRule_AssignmentKey"


    // $ANTLR start "rule_AssignmentKey"
    // InternalGaml.g:3364:1: rule_AssignmentKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '<-' | kw= '<<' | (kw= '>' kw= '>' ) | kw= '<<+' | (kw= '>' kw= '>-' ) | kw= '+<-' | kw= '<+' | kw= '>-' ) ;
    public final AntlrDatatypeRuleToken rule_AssignmentKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGaml.g:3370:2: ( (kw= '<-' | kw= '<<' | (kw= '>' kw= '>' ) | kw= '<<+' | (kw= '>' kw= '>-' ) | kw= '+<-' | kw= '<+' | kw= '>-' ) )
            // InternalGaml.g:3371:2: (kw= '<-' | kw= '<<' | (kw= '>' kw= '>' ) | kw= '<<+' | (kw= '>' kw= '>-' ) | kw= '+<-' | kw= '<+' | kw= '>-' )
            {
            // InternalGaml.g:3371:2: (kw= '<-' | kw= '<<' | (kw= '>' kw= '>' ) | kw= '<<+' | (kw= '>' kw= '>-' ) | kw= '+<-' | kw= '<+' | kw= '>-' )
            int alt61=8;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // InternalGaml.g:3372:3: kw= '<-'
                    {
                    kw=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_AssignmentKeyAccess().getLessThanSignHyphenMinusKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:3378:3: kw= '<<'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_AssignmentKeyAccess().getLessThanSignLessThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGaml.g:3384:3: (kw= '>' kw= '>' )
                    {
                    // InternalGaml.g:3384:3: (kw= '>' kw= '>' )
                    // InternalGaml.g:3385:4: kw= '>' kw= '>'
                    {
                    kw=(Token)match(input,89,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.get_AssignmentKeyAccess().getGreaterThanSignKeyword_2_0());
                      			
                    }
                    kw=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.get_AssignmentKeyAccess().getGreaterThanSignKeyword_2_1());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalGaml.g:3397:3: kw= '<<+'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_AssignmentKeyAccess().getLessThanSignLessThanSignPlusSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalGaml.g:3403:3: (kw= '>' kw= '>-' )
                    {
                    // InternalGaml.g:3403:3: (kw= '>' kw= '>-' )
                    // InternalGaml.g:3404:4: kw= '>' kw= '>-'
                    {
                    kw=(Token)match(input,89,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.get_AssignmentKeyAccess().getGreaterThanSignKeyword_4_0());
                      			
                    }
                    kw=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.get_AssignmentKeyAccess().getGreaterThanSignHyphenMinusKeyword_4_1());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalGaml.g:3416:3: kw= '+<-'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_AssignmentKeyAccess().getPlusSignLessThanSignHyphenMinusKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalGaml.g:3422:3: kw= '<+'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_AssignmentKeyAccess().getLessThanSignPlusSignKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalGaml.g:3428:3: kw= '>-'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.get_AssignmentKeyAccess().getGreaterThanSignHyphenMinusKeyword_7());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rule_AssignmentKey"


    // $ANTLR start "entryRuleActionArguments"
    // InternalGaml.g:3437:1: entryRuleActionArguments returns [EObject current=null] : iv_ruleActionArguments= ruleActionArguments EOF ;
    public final EObject entryRuleActionArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionArguments = null;


        try {
            // InternalGaml.g:3437:56: (iv_ruleActionArguments= ruleActionArguments EOF )
            // InternalGaml.g:3438:2: iv_ruleActionArguments= ruleActionArguments EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActionArgumentsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleActionArguments=ruleActionArguments();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActionArguments; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionArguments"


    // $ANTLR start "ruleActionArguments"
    // InternalGaml.g:3444:1: ruleActionArguments returns [EObject current=null] : ( ( (lv_args_0_0= ruleArgumentDefinition ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleArgumentDefinition ) ) )* ) ;
    public final EObject ruleActionArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_args_0_0 = null;

        EObject lv_args_2_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:3450:2: ( ( ( (lv_args_0_0= ruleArgumentDefinition ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleArgumentDefinition ) ) )* ) )
            // InternalGaml.g:3451:2: ( ( (lv_args_0_0= ruleArgumentDefinition ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleArgumentDefinition ) ) )* )
            {
            // InternalGaml.g:3451:2: ( ( (lv_args_0_0= ruleArgumentDefinition ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleArgumentDefinition ) ) )* )
            // InternalGaml.g:3452:3: ( (lv_args_0_0= ruleArgumentDefinition ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleArgumentDefinition ) ) )*
            {
            // InternalGaml.g:3452:3: ( (lv_args_0_0= ruleArgumentDefinition ) )
            // InternalGaml.g:3453:4: (lv_args_0_0= ruleArgumentDefinition )
            {
            // InternalGaml.g:3453:4: (lv_args_0_0= ruleArgumentDefinition )
            // InternalGaml.g:3454:5: lv_args_0_0= ruleArgumentDefinition
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getActionArgumentsAccess().getArgsArgumentDefinitionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_35);
            lv_args_0_0=ruleArgumentDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getActionArgumentsRule());
              					}
              					add(
              						current,
              						"args",
              						lv_args_0_0,
              						"gama.core.lang.Gaml.ArgumentDefinition");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:3471:3: (otherlv_1= ',' ( (lv_args_2_0= ruleArgumentDefinition ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==94) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalGaml.g:3472:4: otherlv_1= ',' ( (lv_args_2_0= ruleArgumentDefinition ) )
            	    {
            	    otherlv_1=(Token)match(input,94,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getActionArgumentsAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalGaml.g:3476:4: ( (lv_args_2_0= ruleArgumentDefinition ) )
            	    // InternalGaml.g:3477:5: (lv_args_2_0= ruleArgumentDefinition )
            	    {
            	    // InternalGaml.g:3477:5: (lv_args_2_0= ruleArgumentDefinition )
            	    // InternalGaml.g:3478:6: lv_args_2_0= ruleArgumentDefinition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getActionArgumentsAccess().getArgsArgumentDefinitionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_args_2_0=ruleArgumentDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getActionArgumentsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"args",
            	      							lv_args_2_0,
            	      							"gama.core.lang.Gaml.ArgumentDefinition");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionArguments"


    // $ANTLR start "entryRuleArgumentDefinition"
    // InternalGaml.g:3500:1: entryRuleArgumentDefinition returns [EObject current=null] : iv_ruleArgumentDefinition= ruleArgumentDefinition EOF ;
    public final EObject entryRuleArgumentDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentDefinition = null;


        try {
            // InternalGaml.g:3500:59: (iv_ruleArgumentDefinition= ruleArgumentDefinition EOF )
            // InternalGaml.g:3501:2: iv_ruleArgumentDefinition= ruleArgumentDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArgumentDefinition=ruleArgumentDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArgumentDefinition"


    // $ANTLR start "ruleArgumentDefinition"
    // InternalGaml.g:3507:1: ruleArgumentDefinition returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRef ) ) ( (lv_name_1_0= ruleValid_ID ) ) (otherlv_2= '<-' ( (lv_default_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleArgumentDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:3513:2: ( ( ( (lv_type_0_0= ruleTypeRef ) ) ( (lv_name_1_0= ruleValid_ID ) ) (otherlv_2= '<-' ( (lv_default_3_0= ruleExpression ) ) )? ) )
            // InternalGaml.g:3514:2: ( ( (lv_type_0_0= ruleTypeRef ) ) ( (lv_name_1_0= ruleValid_ID ) ) (otherlv_2= '<-' ( (lv_default_3_0= ruleExpression ) ) )? )
            {
            // InternalGaml.g:3514:2: ( ( (lv_type_0_0= ruleTypeRef ) ) ( (lv_name_1_0= ruleValid_ID ) ) (otherlv_2= '<-' ( (lv_default_3_0= ruleExpression ) ) )? )
            // InternalGaml.g:3515:3: ( (lv_type_0_0= ruleTypeRef ) ) ( (lv_name_1_0= ruleValid_ID ) ) (otherlv_2= '<-' ( (lv_default_3_0= ruleExpression ) ) )?
            {
            // InternalGaml.g:3515:3: ( (lv_type_0_0= ruleTypeRef ) )
            // InternalGaml.g:3516:4: (lv_type_0_0= ruleTypeRef )
            {
            // InternalGaml.g:3516:4: (lv_type_0_0= ruleTypeRef )
            // InternalGaml.g:3517:5: lv_type_0_0= ruleTypeRef
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArgumentDefinitionAccess().getTypeTypeRefParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_type_0_0=ruleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArgumentDefinitionRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"gama.core.lang.Gaml.TypeRef");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:3534:3: ( (lv_name_1_0= ruleValid_ID ) )
            // InternalGaml.g:3535:4: (lv_name_1_0= ruleValid_ID )
            {
            // InternalGaml.g:3535:4: (lv_name_1_0= ruleValid_ID )
            // InternalGaml.g:3536:5: lv_name_1_0= ruleValid_ID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArgumentDefinitionAccess().getNameValid_IDParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_36);
            lv_name_1_0=ruleValid_ID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArgumentDefinitionRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"gama.core.lang.Gaml.Valid_ID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:3553:3: (otherlv_2= '<-' ( (lv_default_3_0= ruleExpression ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==15) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalGaml.g:3554:4: otherlv_2= '<-' ( (lv_default_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getArgumentDefinitionAccess().getLessThanSignHyphenMinusKeyword_2_0());
                      			
                    }
                    // InternalGaml.g:3558:4: ( (lv_default_3_0= ruleExpression ) )
                    // InternalGaml.g:3559:5: (lv_default_3_0= ruleExpression )
                    {
                    // InternalGaml.g:3559:5: (lv_default_3_0= ruleExpression )
                    // InternalGaml.g:3560:6: lv_default_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArgumentDefinitionAccess().getDefaultExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getArgumentDefinitionRule());
                      						}
                      						set(
                      							current,
                      							"default",
                      							lv_default_3_0,
                      							"gama.core.lang.Gaml.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArgumentDefinition"


    // $ANTLR start "entryRuleFacet"
    // InternalGaml.g:3582:1: entryRuleFacet returns [EObject current=null] : iv_ruleFacet= ruleFacet EOF ;
    public final EObject entryRuleFacet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFacet = null;


        try {
            // InternalGaml.g:3582:46: (iv_ruleFacet= ruleFacet EOF )
            // InternalGaml.g:3583:2: iv_ruleFacet= ruleFacet EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFacetRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFacet=ruleFacet();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFacet; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFacet"


    // $ANTLR start "ruleFacet"
    // InternalGaml.g:3589:1: ruleFacet returns [EObject current=null] : (this_ActionFacet_0= ruleActionFacet | this_DefinitionFacet_1= ruleDefinitionFacet | this_ClassicFacet_2= ruleClassicFacet | this_TypeFacet_3= ruleTypeFacet | this_FunctionFacet_4= ruleFunctionFacet ) ;
    public final EObject ruleFacet() throws RecognitionException {
        EObject current = null;

        EObject this_ActionFacet_0 = null;

        EObject this_DefinitionFacet_1 = null;

        EObject this_ClassicFacet_2 = null;

        EObject this_TypeFacet_3 = null;

        EObject this_FunctionFacet_4 = null;



        	enterRule();

        try {
            // InternalGaml.g:3595:2: ( (this_ActionFacet_0= ruleActionFacet | this_DefinitionFacet_1= ruleDefinitionFacet | this_ClassicFacet_2= ruleClassicFacet | this_TypeFacet_3= ruleTypeFacet | this_FunctionFacet_4= ruleFunctionFacet ) )
            // InternalGaml.g:3596:2: (this_ActionFacet_0= ruleActionFacet | this_DefinitionFacet_1= ruleDefinitionFacet | this_ClassicFacet_2= ruleClassicFacet | this_TypeFacet_3= ruleTypeFacet | this_FunctionFacet_4= ruleFunctionFacet )
            {
            // InternalGaml.g:3596:2: (this_ActionFacet_0= ruleActionFacet | this_DefinitionFacet_1= ruleDefinitionFacet | this_ClassicFacet_2= ruleClassicFacet | this_TypeFacet_3= ruleTypeFacet | this_FunctionFacet_4= ruleFunctionFacet )
            int alt64=5;
            switch ( input.LA(1) ) {
            case 117:
            case 118:
                {
                alt64=1;
                }
                break;
            case 95:
            case 96:
                {
                alt64=2;
                }
                break;
            case RULE_ID:
            case 15:
            case 29:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
                {
                alt64=3;
                }
                break;
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                {
                alt64=4;
                }
                break;
            case 119:
                {
                alt64=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalGaml.g:3597:3: this_ActionFacet_0= ruleActionFacet
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFacetAccess().getActionFacetParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ActionFacet_0=ruleActionFacet();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ActionFacet_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:3606:3: this_DefinitionFacet_1= ruleDefinitionFacet
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFacetAccess().getDefinitionFacetParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DefinitionFacet_1=ruleDefinitionFacet();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DefinitionFacet_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGaml.g:3615:3: this_ClassicFacet_2= ruleClassicFacet
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFacetAccess().getClassicFacetParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ClassicFacet_2=ruleClassicFacet();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ClassicFacet_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalGaml.g:3624:3: this_TypeFacet_3= ruleTypeFacet
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFacetAccess().getTypeFacetParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeFacet_3=ruleTypeFacet();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeFacet_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalGaml.g:3633:3: this_FunctionFacet_4= ruleFunctionFacet
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFacetAccess().getFunctionFacetParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FunctionFacet_4=ruleFunctionFacet();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FunctionFacet_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFacet"


    // $ANTLR start "entryRuleClassicFacetKey"
    // InternalGaml.g:3645:1: entryRuleClassicFacetKey returns [String current=null] : iv_ruleClassicFacetKey= ruleClassicFacetKey EOF ;
    public final String entryRuleClassicFacetKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleClassicFacetKey = null;


        try {
            // InternalGaml.g:3645:55: (iv_ruleClassicFacetKey= ruleClassicFacetKey EOF )
            // InternalGaml.g:3646:2: iv_ruleClassicFacetKey= ruleClassicFacetKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassicFacetKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClassicFacetKey=ruleClassicFacetKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassicFacetKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassicFacetKey"


    // $ANTLR start "ruleClassicFacetKey"
    // InternalGaml.g:3652:1: ruleClassicFacetKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= ':' ) ;
    public final AntlrDatatypeRuleToken ruleClassicFacetKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalGaml.g:3658:2: ( (this_ID_0= RULE_ID kw= ':' ) )
            // InternalGaml.g:3659:2: (this_ID_0= RULE_ID kw= ':' )
            {
            // InternalGaml.g:3659:2: (this_ID_0= RULE_ID kw= ':' )
            // InternalGaml.g:3660:3: this_ID_0= RULE_ID kw= ':'
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getClassicFacetKeyAccess().getIDTerminalRuleCall_0());
              		
            }
            kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getClassicFacetKeyAccess().getColonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassicFacetKey"


    // $ANTLR start "entryRuleDefinitionFacetKey"
    // InternalGaml.g:3676:1: entryRuleDefinitionFacetKey returns [String current=null] : iv_ruleDefinitionFacetKey= ruleDefinitionFacetKey EOF ;
    public final String entryRuleDefinitionFacetKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDefinitionFacetKey = null;


        try {
            // InternalGaml.g:3676:58: (iv_ruleDefinitionFacetKey= ruleDefinitionFacetKey EOF )
            // InternalGaml.g:3677:2: iv_ruleDefinitionFacetKey= ruleDefinitionFacetKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefinitionFacetKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDefinitionFacetKey=ruleDefinitionFacetKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefinitionFacetKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinitionFacetKey"


    // $ANTLR start "ruleDefinitionFacetKey"
    // InternalGaml.g:3683:1: ruleDefinitionFacetKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'name:' | kw= 'returns:' ) ;
    public final AntlrDatatypeRuleToken ruleDefinitionFacetKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGaml.g:3689:2: ( (kw= 'name:' | kw= 'returns:' ) )
            // InternalGaml.g:3690:2: (kw= 'name:' | kw= 'returns:' )
            {
            // InternalGaml.g:3690:2: (kw= 'name:' | kw= 'returns:' )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==95) ) {
                alt65=1;
            }
            else if ( (LA65_0==96) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalGaml.g:3691:3: kw= 'name:'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getDefinitionFacetKeyAccess().getNameKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:3697:3: kw= 'returns:'
                    {
                    kw=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getDefinitionFacetKeyAccess().getReturnsKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinitionFacetKey"


    // $ANTLR start "entryRuleTypeFacetKey"
    // InternalGaml.g:3706:1: entryRuleTypeFacetKey returns [String current=null] : iv_ruleTypeFacetKey= ruleTypeFacetKey EOF ;
    public final String entryRuleTypeFacetKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTypeFacetKey = null;


        try {
            // InternalGaml.g:3706:52: (iv_ruleTypeFacetKey= ruleTypeFacetKey EOF )
            // InternalGaml.g:3707:2: iv_ruleTypeFacetKey= ruleTypeFacetKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeFacetKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeFacetKey=ruleTypeFacetKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeFacetKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeFacetKey"


    // $ANTLR start "ruleTypeFacetKey"
    // InternalGaml.g:3713:1: ruleTypeFacetKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'as:' | kw= 'of:' | kw= 'parent:' | kw= 'species:' | kw= 'type:' ) ;
    public final AntlrDatatypeRuleToken ruleTypeFacetKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGaml.g:3719:2: ( (kw= 'as:' | kw= 'of:' | kw= 'parent:' | kw= 'species:' | kw= 'type:' ) )
            // InternalGaml.g:3720:2: (kw= 'as:' | kw= 'of:' | kw= 'parent:' | kw= 'species:' | kw= 'type:' )
            {
            // InternalGaml.g:3720:2: (kw= 'as:' | kw= 'of:' | kw= 'parent:' | kw= 'species:' | kw= 'type:' )
            int alt66=5;
            switch ( input.LA(1) ) {
            case 97:
                {
                alt66=1;
                }
                break;
            case 98:
                {
                alt66=2;
                }
                break;
            case 99:
                {
                alt66=3;
                }
                break;
            case 100:
                {
                alt66=4;
                }
                break;
            case 101:
                {
                alt66=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalGaml.g:3721:3: kw= 'as:'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeFacetKeyAccess().getAsKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:3727:3: kw= 'of:'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeFacetKeyAccess().getOfKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGaml.g:3733:3: kw= 'parent:'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeFacetKeyAccess().getParentKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalGaml.g:3739:3: kw= 'species:'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeFacetKeyAccess().getSpeciesKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalGaml.g:3745:3: kw= 'type:'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getTypeFacetKeyAccess().getTypeKeyword_4());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeFacetKey"


    // $ANTLR start "entryRuleSpecialFacetKey"
    // InternalGaml.g:3754:1: entryRuleSpecialFacetKey returns [String current=null] : iv_ruleSpecialFacetKey= ruleSpecialFacetKey EOF ;
    public final String entryRuleSpecialFacetKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpecialFacetKey = null;


        try {
            // InternalGaml.g:3754:55: (iv_ruleSpecialFacetKey= ruleSpecialFacetKey EOF )
            // InternalGaml.g:3755:2: iv_ruleSpecialFacetKey= ruleSpecialFacetKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpecialFacetKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSpecialFacetKey=ruleSpecialFacetKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpecialFacetKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecialFacetKey"


    // $ANTLR start "ruleSpecialFacetKey"
    // InternalGaml.g:3761:1: ruleSpecialFacetKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'data:' | (kw= 'when' kw= ':' ) | kw= 'value:' | kw= 'topology:' | kw= 'item:' | kw= 'init:' | kw= 'message:' | kw= 'control:' | kw= 'layout:' | kw= 'environment:' | kw= 'text:' | kw= 'image:' | kw= 'using:' | kw= 'parameter:' | kw= 'aspect:' | kw= 'light:' ) ;
    public final AntlrDatatypeRuleToken ruleSpecialFacetKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGaml.g:3767:2: ( (kw= 'data:' | (kw= 'when' kw= ':' ) | kw= 'value:' | kw= 'topology:' | kw= 'item:' | kw= 'init:' | kw= 'message:' | kw= 'control:' | kw= 'layout:' | kw= 'environment:' | kw= 'text:' | kw= 'image:' | kw= 'using:' | kw= 'parameter:' | kw= 'aspect:' | kw= 'light:' ) )
            // InternalGaml.g:3768:2: (kw= 'data:' | (kw= 'when' kw= ':' ) | kw= 'value:' | kw= 'topology:' | kw= 'item:' | kw= 'init:' | kw= 'message:' | kw= 'control:' | kw= 'layout:' | kw= 'environment:' | kw= 'text:' | kw= 'image:' | kw= 'using:' | kw= 'parameter:' | kw= 'aspect:' | kw= 'light:' )
            {
            // InternalGaml.g:3768:2: (kw= 'data:' | (kw= 'when' kw= ':' ) | kw= 'value:' | kw= 'topology:' | kw= 'item:' | kw= 'init:' | kw= 'message:' | kw= 'control:' | kw= 'layout:' | kw= 'environment:' | kw= 'text:' | kw= 'image:' | kw= 'using:' | kw= 'parameter:' | kw= 'aspect:' | kw= 'light:' )
            int alt67=16;
            switch ( input.LA(1) ) {
            case 102:
                {
                alt67=1;
                }
                break;
            case 29:
                {
                alt67=2;
                }
                break;
            case 103:
                {
                alt67=3;
                }
                break;
            case 104:
                {
                alt67=4;
                }
                break;
            case 105:
                {
                alt67=5;
                }
                break;
            case 106:
                {
                alt67=6;
                }
                break;
            case 107:
                {
                alt67=7;
                }
                break;
            case 108:
                {
                alt67=8;
                }
                break;
            case 109:
                {
                alt67=9;
                }
                break;
            case 110:
                {
                alt67=10;
                }
                break;
            case 111:
                {
                alt67=11;
                }
                break;
            case 112:
                {
                alt67=12;
                }
                break;
            case 113:
                {
                alt67=13;
                }
                break;
            case 114:
                {
                alt67=14;
                }
                break;
            case 115:
                {
                alt67=15;
                }
                break;
            case 116:
                {
                alt67=16;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // InternalGaml.g:3769:3: kw= 'data:'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getDataKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:3775:3: (kw= 'when' kw= ':' )
                    {
                    // InternalGaml.g:3775:3: (kw= 'when' kw= ':' )
                    // InternalGaml.g:3776:4: kw= 'when' kw= ':'
                    {
                    kw=(Token)match(input,29,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getWhenKeyword_1_0());
                      			
                    }
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getColonKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalGaml.g:3788:3: kw= 'value:'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getValueKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalGaml.g:3794:3: kw= 'topology:'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getTopologyKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalGaml.g:3800:3: kw= 'item:'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getItemKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalGaml.g:3806:3: kw= 'init:'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getInitKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalGaml.g:3812:3: kw= 'message:'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getMessageKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalGaml.g:3818:3: kw= 'control:'
                    {
                    kw=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getControlKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalGaml.g:3824:3: kw= 'layout:'
                    {
                    kw=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getLayoutKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalGaml.g:3830:3: kw= 'environment:'
                    {
                    kw=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getEnvironmentKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalGaml.g:3836:3: kw= 'text:'
                    {
                    kw=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getTextKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalGaml.g:3842:3: kw= 'image:'
                    {
                    kw=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getImageKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalGaml.g:3848:3: kw= 'using:'
                    {
                    kw=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getUsingKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalGaml.g:3854:3: kw= 'parameter:'
                    {
                    kw=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getParameterKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalGaml.g:3860:3: kw= 'aspect:'
                    {
                    kw=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getAspectKeyword_14());
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalGaml.g:3866:3: kw= 'light:'
                    {
                    kw=(Token)match(input,116,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSpecialFacetKeyAccess().getLightKeyword_15());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecialFacetKey"


    // $ANTLR start "entryRuleActionFacetKey"
    // InternalGaml.g:3875:1: entryRuleActionFacetKey returns [String current=null] : iv_ruleActionFacetKey= ruleActionFacetKey EOF ;
    public final String entryRuleActionFacetKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleActionFacetKey = null;


        try {
            // InternalGaml.g:3875:54: (iv_ruleActionFacetKey= ruleActionFacetKey EOF )
            // InternalGaml.g:3876:2: iv_ruleActionFacetKey= ruleActionFacetKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActionFacetKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleActionFacetKey=ruleActionFacetKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActionFacetKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionFacetKey"


    // $ANTLR start "ruleActionFacetKey"
    // InternalGaml.g:3882:1: ruleActionFacetKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'action:' | kw= 'on_change:' ) ;
    public final AntlrDatatypeRuleToken ruleActionFacetKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalGaml.g:3888:2: ( (kw= 'action:' | kw= 'on_change:' ) )
            // InternalGaml.g:3889:2: (kw= 'action:' | kw= 'on_change:' )
            {
            // InternalGaml.g:3889:2: (kw= 'action:' | kw= 'on_change:' )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==117) ) {
                alt68=1;
            }
            else if ( (LA68_0==118) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalGaml.g:3890:3: kw= 'action:'
                    {
                    kw=(Token)match(input,117,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getActionFacetKeyAccess().getActionKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:3896:3: kw= 'on_change:'
                    {
                    kw=(Token)match(input,118,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getActionFacetKeyAccess().getOn_changeKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionFacetKey"


    // $ANTLR start "entryRuleClassicFacet"
    // InternalGaml.g:3905:1: entryRuleClassicFacet returns [EObject current=null] : iv_ruleClassicFacet= ruleClassicFacet EOF ;
    public final EObject entryRuleClassicFacet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassicFacet = null;


        try {
            // InternalGaml.g:3905:53: (iv_ruleClassicFacet= ruleClassicFacet EOF )
            // InternalGaml.g:3906:2: iv_ruleClassicFacet= ruleClassicFacet EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassicFacetRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClassicFacet=ruleClassicFacet();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassicFacet; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassicFacet"


    // $ANTLR start "ruleClassicFacet"
    // InternalGaml.g:3912:1: ruleClassicFacet returns [EObject current=null] : ( ( ( (lv_key_0_0= ruleClassicFacetKey ) ) | ( (lv_key_1_0= '<-' ) ) | ( (lv_key_2_0= ruleSpecialFacetKey ) ) ) ( (lv_expr_3_0= ruleExpression ) ) ) ;
    public final EObject ruleClassicFacet() throws RecognitionException {
        EObject current = null;

        Token lv_key_1_0=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        AntlrDatatypeRuleToken lv_key_2_0 = null;

        EObject lv_expr_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:3918:2: ( ( ( ( (lv_key_0_0= ruleClassicFacetKey ) ) | ( (lv_key_1_0= '<-' ) ) | ( (lv_key_2_0= ruleSpecialFacetKey ) ) ) ( (lv_expr_3_0= ruleExpression ) ) ) )
            // InternalGaml.g:3919:2: ( ( ( (lv_key_0_0= ruleClassicFacetKey ) ) | ( (lv_key_1_0= '<-' ) ) | ( (lv_key_2_0= ruleSpecialFacetKey ) ) ) ( (lv_expr_3_0= ruleExpression ) ) )
            {
            // InternalGaml.g:3919:2: ( ( ( (lv_key_0_0= ruleClassicFacetKey ) ) | ( (lv_key_1_0= '<-' ) ) | ( (lv_key_2_0= ruleSpecialFacetKey ) ) ) ( (lv_expr_3_0= ruleExpression ) ) )
            // InternalGaml.g:3920:3: ( ( (lv_key_0_0= ruleClassicFacetKey ) ) | ( (lv_key_1_0= '<-' ) ) | ( (lv_key_2_0= ruleSpecialFacetKey ) ) ) ( (lv_expr_3_0= ruleExpression ) )
            {
            // InternalGaml.g:3920:3: ( ( (lv_key_0_0= ruleClassicFacetKey ) ) | ( (lv_key_1_0= '<-' ) ) | ( (lv_key_2_0= ruleSpecialFacetKey ) ) )
            int alt69=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt69=1;
                }
                break;
            case 15:
                {
                alt69=2;
                }
                break;
            case 29:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
                {
                alt69=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // InternalGaml.g:3921:4: ( (lv_key_0_0= ruleClassicFacetKey ) )
                    {
                    // InternalGaml.g:3921:4: ( (lv_key_0_0= ruleClassicFacetKey ) )
                    // InternalGaml.g:3922:5: (lv_key_0_0= ruleClassicFacetKey )
                    {
                    // InternalGaml.g:3922:5: (lv_key_0_0= ruleClassicFacetKey )
                    // InternalGaml.g:3923:6: lv_key_0_0= ruleClassicFacetKey
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getClassicFacetAccess().getKeyClassicFacetKeyParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_5);
                    lv_key_0_0=ruleClassicFacetKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getClassicFacetRule());
                      						}
                      						set(
                      							current,
                      							"key",
                      							lv_key_0_0,
                      							"gama.core.lang.Gaml.ClassicFacetKey");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:3941:4: ( (lv_key_1_0= '<-' ) )
                    {
                    // InternalGaml.g:3941:4: ( (lv_key_1_0= '<-' ) )
                    // InternalGaml.g:3942:5: (lv_key_1_0= '<-' )
                    {
                    // InternalGaml.g:3942:5: (lv_key_1_0= '<-' )
                    // InternalGaml.g:3943:6: lv_key_1_0= '<-'
                    {
                    lv_key_1_0=(Token)match(input,15,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_key_1_0, grammarAccess.getClassicFacetAccess().getKeyLessThanSignHyphenMinusKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getClassicFacetRule());
                      						}
                      						setWithLastConsumed(current, "key", lv_key_1_0, "<-");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGaml.g:3956:4: ( (lv_key_2_0= ruleSpecialFacetKey ) )
                    {
                    // InternalGaml.g:3956:4: ( (lv_key_2_0= ruleSpecialFacetKey ) )
                    // InternalGaml.g:3957:5: (lv_key_2_0= ruleSpecialFacetKey )
                    {
                    // InternalGaml.g:3957:5: (lv_key_2_0= ruleSpecialFacetKey )
                    // InternalGaml.g:3958:6: lv_key_2_0= ruleSpecialFacetKey
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getClassicFacetAccess().getKeySpecialFacetKeyParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_5);
                    lv_key_2_0=ruleSpecialFacetKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getClassicFacetRule());
                      						}
                      						set(
                      							current,
                      							"key",
                      							lv_key_2_0,
                      							"gama.core.lang.Gaml.SpecialFacetKey");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalGaml.g:3976:3: ( (lv_expr_3_0= ruleExpression ) )
            // InternalGaml.g:3977:4: (lv_expr_3_0= ruleExpression )
            {
            // InternalGaml.g:3977:4: (lv_expr_3_0= ruleExpression )
            // InternalGaml.g:3978:5: lv_expr_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getClassicFacetAccess().getExprExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expr_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getClassicFacetRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_3_0,
              						"gama.core.lang.Gaml.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassicFacet"


    // $ANTLR start "entryRuleDefinitionFacet"
    // InternalGaml.g:3999:1: entryRuleDefinitionFacet returns [EObject current=null] : iv_ruleDefinitionFacet= ruleDefinitionFacet EOF ;
    public final EObject entryRuleDefinitionFacet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitionFacet = null;


        try {
            // InternalGaml.g:3999:56: (iv_ruleDefinitionFacet= ruleDefinitionFacet EOF )
            // InternalGaml.g:4000:2: iv_ruleDefinitionFacet= ruleDefinitionFacet EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefinitionFacetRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDefinitionFacet=ruleDefinitionFacet();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefinitionFacet; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinitionFacet"


    // $ANTLR start "ruleDefinitionFacet"
    // InternalGaml.g:4006:1: ruleDefinitionFacet returns [EObject current=null] : ( ( ( 'name:' | 'returns:' )=> (lv_key_0_0= ruleDefinitionFacetKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) ) ;
    public final EObject ruleDefinitionFacet() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_2=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_1 = null;



        	enterRule();

        try {
            // InternalGaml.g:4012:2: ( ( ( ( 'name:' | 'returns:' )=> (lv_key_0_0= ruleDefinitionFacetKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) ) )
            // InternalGaml.g:4013:2: ( ( ( 'name:' | 'returns:' )=> (lv_key_0_0= ruleDefinitionFacetKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) )
            {
            // InternalGaml.g:4013:2: ( ( ( 'name:' | 'returns:' )=> (lv_key_0_0= ruleDefinitionFacetKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) ) )
            // InternalGaml.g:4014:3: ( ( 'name:' | 'returns:' )=> (lv_key_0_0= ruleDefinitionFacetKey ) ) ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) )
            {
            // InternalGaml.g:4014:3: ( ( 'name:' | 'returns:' )=> (lv_key_0_0= ruleDefinitionFacetKey ) )
            // InternalGaml.g:4015:4: ( 'name:' | 'returns:' )=> (lv_key_0_0= ruleDefinitionFacetKey )
            {
            // InternalGaml.g:4016:4: (lv_key_0_0= ruleDefinitionFacetKey )
            // InternalGaml.g:4017:5: lv_key_0_0= ruleDefinitionFacetKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDefinitionFacetAccess().getKeyDefinitionFacetKeyParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_key_0_0=ruleDefinitionFacetKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDefinitionFacetRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_0_0,
              						"gama.core.lang.Gaml.DefinitionFacetKey");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:4034:3: ( ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) ) )
            // InternalGaml.g:4035:4: ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) )
            {
            // InternalGaml.g:4035:4: ( (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING ) )
            // InternalGaml.g:4036:5: (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING )
            {
            // InternalGaml.g:4036:5: (lv_name_1_1= ruleValid_ID | lv_name_1_2= RULE_STRING )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ID||LA70_0==38||(LA70_0>=40 && LA70_0<=87)) ) {
                alt70=1;
            }
            else if ( (LA70_0==RULE_STRING) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalGaml.g:4037:6: lv_name_1_1= ruleValid_ID
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDefinitionFacetAccess().getNameValid_IDParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_name_1_1=ruleValid_ID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDefinitionFacetRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_1_1,
                      							"gama.core.lang.Gaml.Valid_ID");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:4053:6: lv_name_1_2= RULE_STRING
                    {
                    lv_name_1_2=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_2, grammarAccess.getDefinitionFacetAccess().getNameSTRINGTerminalRuleCall_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDefinitionFacetRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_1_2,
                      							"gama.core.lang.Gaml.STRING");
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinitionFacet"


    // $ANTLR start "entryRuleFunctionFacet"
    // InternalGaml.g:4074:1: entryRuleFunctionFacet returns [EObject current=null] : iv_ruleFunctionFacet= ruleFunctionFacet EOF ;
    public final EObject entryRuleFunctionFacet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionFacet = null;


        try {
            // InternalGaml.g:4074:54: (iv_ruleFunctionFacet= ruleFunctionFacet EOF )
            // InternalGaml.g:4075:2: iv_ruleFunctionFacet= ruleFunctionFacet EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionFacetRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionFacet=ruleFunctionFacet();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionFacet; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionFacet"


    // $ANTLR start "ruleFunctionFacet"
    // InternalGaml.g:4081:1: ruleFunctionFacet returns [EObject current=null] : ( ( (lv_key_0_0= '->' ) ) ( ( ( ( ( ruleExpression ) ) )=> ( (lv_expr_1_0= ruleExpression ) ) ) | (otherlv_2= '{' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= '}' ) ) ) ;
    public final EObject ruleFunctionFacet() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expr_1_0 = null;

        EObject lv_expr_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:4087:2: ( ( ( (lv_key_0_0= '->' ) ) ( ( ( ( ( ruleExpression ) ) )=> ( (lv_expr_1_0= ruleExpression ) ) ) | (otherlv_2= '{' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= '}' ) ) ) )
            // InternalGaml.g:4088:2: ( ( (lv_key_0_0= '->' ) ) ( ( ( ( ( ruleExpression ) ) )=> ( (lv_expr_1_0= ruleExpression ) ) ) | (otherlv_2= '{' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= '}' ) ) )
            {
            // InternalGaml.g:4088:2: ( ( (lv_key_0_0= '->' ) ) ( ( ( ( ( ruleExpression ) ) )=> ( (lv_expr_1_0= ruleExpression ) ) ) | (otherlv_2= '{' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= '}' ) ) )
            // InternalGaml.g:4089:3: ( (lv_key_0_0= '->' ) ) ( ( ( ( ( ruleExpression ) ) )=> ( (lv_expr_1_0= ruleExpression ) ) ) | (otherlv_2= '{' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            {
            // InternalGaml.g:4089:3: ( (lv_key_0_0= '->' ) )
            // InternalGaml.g:4090:4: (lv_key_0_0= '->' )
            {
            // InternalGaml.g:4090:4: (lv_key_0_0= '->' )
            // InternalGaml.g:4091:5: lv_key_0_0= '->'
            {
            lv_key_0_0=(Token)match(input,119,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_key_0_0, grammarAccess.getFunctionFacetAccess().getKeyHyphenMinusGreaterThanSignKeyword_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionFacetRule());
              					}
              					setWithLastConsumed(current, "key", lv_key_0_0, "->");
              				
            }

            }


            }

            // InternalGaml.g:4103:3: ( ( ( ( ( ruleExpression ) ) )=> ( (lv_expr_1_0= ruleExpression ) ) ) | (otherlv_2= '{' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            int alt71=2;
            alt71 = dfa71.predict(input);
            switch (alt71) {
                case 1 :
                    // InternalGaml.g:4104:4: ( ( ( ( ruleExpression ) ) )=> ( (lv_expr_1_0= ruleExpression ) ) )
                    {
                    // InternalGaml.g:4104:4: ( ( ( ( ruleExpression ) ) )=> ( (lv_expr_1_0= ruleExpression ) ) )
                    // InternalGaml.g:4105:5: ( ( ( ruleExpression ) ) )=> ( (lv_expr_1_0= ruleExpression ) )
                    {
                    // InternalGaml.g:4111:5: ( (lv_expr_1_0= ruleExpression ) )
                    // InternalGaml.g:4112:6: (lv_expr_1_0= ruleExpression )
                    {
                    // InternalGaml.g:4112:6: (lv_expr_1_0= ruleExpression )
                    // InternalGaml.g:4113:7: lv_expr_1_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getFunctionFacetAccess().getExprExpressionParserRuleCall_1_0_0_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_1_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getFunctionFacetRule());
                      							}
                      							set(
                      								current,
                      								"expr",
                      								lv_expr_1_0,
                      								"gama.core.lang.Gaml.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:4132:4: (otherlv_2= '{' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= '}' )
                    {
                    // InternalGaml.g:4132:4: (otherlv_2= '{' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= '}' )
                    // InternalGaml.g:4133:5: otherlv_2= '{' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getFunctionFacetAccess().getLeftCurlyBracketKeyword_1_1_0());
                      				
                    }
                    // InternalGaml.g:4137:5: ( (lv_expr_3_0= ruleExpression ) )
                    // InternalGaml.g:4138:6: (lv_expr_3_0= ruleExpression )
                    {
                    // InternalGaml.g:4138:6: (lv_expr_3_0= ruleExpression )
                    // InternalGaml.g:4139:7: lv_expr_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getFunctionFacetAccess().getExprExpressionParserRuleCall_1_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_37);
                    lv_expr_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getFunctionFacetRule());
                      							}
                      							set(
                      								current,
                      								"expr",
                      								lv_expr_3_0,
                      								"gama.core.lang.Gaml.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getFunctionFacetAccess().getRightCurlyBracketKeyword_1_1_2());
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionFacet"


    // $ANTLR start "entryRuleTypeFacet"
    // InternalGaml.g:4166:1: entryRuleTypeFacet returns [EObject current=null] : iv_ruleTypeFacet= ruleTypeFacet EOF ;
    public final EObject entryRuleTypeFacet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeFacet = null;


        try {
            // InternalGaml.g:4166:50: (iv_ruleTypeFacet= ruleTypeFacet EOF )
            // InternalGaml.g:4167:2: iv_ruleTypeFacet= ruleTypeFacet EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeFacetRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeFacet=ruleTypeFacet();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeFacet; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeFacet"


    // $ANTLR start "ruleTypeFacet"
    // InternalGaml.g:4173:1: ruleTypeFacet returns [EObject current=null] : ( ( (lv_key_0_0= ruleTypeFacetKey ) ) ( ( ( 'species' | RULE_ID )=> ( (lv_expr_1_0= ruleTypeRef ) ) ) | ( (lv_expr_2_0= ruleExpression ) ) ) ) ;
    public final EObject ruleTypeFacet() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_expr_1_0 = null;

        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:4179:2: ( ( ( (lv_key_0_0= ruleTypeFacetKey ) ) ( ( ( 'species' | RULE_ID )=> ( (lv_expr_1_0= ruleTypeRef ) ) ) | ( (lv_expr_2_0= ruleExpression ) ) ) ) )
            // InternalGaml.g:4180:2: ( ( (lv_key_0_0= ruleTypeFacetKey ) ) ( ( ( 'species' | RULE_ID )=> ( (lv_expr_1_0= ruleTypeRef ) ) ) | ( (lv_expr_2_0= ruleExpression ) ) ) )
            {
            // InternalGaml.g:4180:2: ( ( (lv_key_0_0= ruleTypeFacetKey ) ) ( ( ( 'species' | RULE_ID )=> ( (lv_expr_1_0= ruleTypeRef ) ) ) | ( (lv_expr_2_0= ruleExpression ) ) ) )
            // InternalGaml.g:4181:3: ( (lv_key_0_0= ruleTypeFacetKey ) ) ( ( ( 'species' | RULE_ID )=> ( (lv_expr_1_0= ruleTypeRef ) ) ) | ( (lv_expr_2_0= ruleExpression ) ) )
            {
            // InternalGaml.g:4181:3: ( (lv_key_0_0= ruleTypeFacetKey ) )
            // InternalGaml.g:4182:4: (lv_key_0_0= ruleTypeFacetKey )
            {
            // InternalGaml.g:4182:4: (lv_key_0_0= ruleTypeFacetKey )
            // InternalGaml.g:4183:5: lv_key_0_0= ruleTypeFacetKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeFacetAccess().getKeyTypeFacetKeyParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_key_0_0=ruleTypeFacetKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypeFacetRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_0_0,
              						"gama.core.lang.Gaml.TypeFacetKey");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:4200:3: ( ( ( 'species' | RULE_ID )=> ( (lv_expr_1_0= ruleTypeRef ) ) ) | ( (lv_expr_2_0= ruleExpression ) ) )
            int alt72=2;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // InternalGaml.g:4201:4: ( ( 'species' | RULE_ID )=> ( (lv_expr_1_0= ruleTypeRef ) ) )
                    {
                    // InternalGaml.g:4201:4: ( ( 'species' | RULE_ID )=> ( (lv_expr_1_0= ruleTypeRef ) ) )
                    // InternalGaml.g:4202:5: ( 'species' | RULE_ID )=> ( (lv_expr_1_0= ruleTypeRef ) )
                    {
                    // InternalGaml.g:4203:5: ( (lv_expr_1_0= ruleTypeRef ) )
                    // InternalGaml.g:4204:6: (lv_expr_1_0= ruleTypeRef )
                    {
                    // InternalGaml.g:4204:6: (lv_expr_1_0= ruleTypeRef )
                    // InternalGaml.g:4205:7: lv_expr_1_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getTypeFacetAccess().getExprTypeRefParserRuleCall_1_0_0_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_1_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getTypeFacetRule());
                      							}
                      							set(
                      								current,
                      								"expr",
                      								lv_expr_1_0,
                      								"gama.core.lang.Gaml.TypeRef");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:4224:4: ( (lv_expr_2_0= ruleExpression ) )
                    {
                    // InternalGaml.g:4224:4: ( (lv_expr_2_0= ruleExpression ) )
                    // InternalGaml.g:4225:5: (lv_expr_2_0= ruleExpression )
                    {
                    // InternalGaml.g:4225:5: (lv_expr_2_0= ruleExpression )
                    // InternalGaml.g:4226:6: lv_expr_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeFacetAccess().getExprExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTypeFacetRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_2_0,
                      							"gama.core.lang.Gaml.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeFacet"


    // $ANTLR start "entryRuleActionFacet"
    // InternalGaml.g:4248:1: entryRuleActionFacet returns [EObject current=null] : iv_ruleActionFacet= ruleActionFacet EOF ;
    public final EObject entryRuleActionFacet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionFacet = null;


        try {
            // InternalGaml.g:4248:52: (iv_ruleActionFacet= ruleActionFacet EOF )
            // InternalGaml.g:4249:2: iv_ruleActionFacet= ruleActionFacet EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActionFacetRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleActionFacet=ruleActionFacet();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActionFacet; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionFacet"


    // $ANTLR start "ruleActionFacet"
    // InternalGaml.g:4255:1: ruleActionFacet returns [EObject current=null] : ( ( (lv_key_0_0= ruleActionFacetKey ) ) ( ( (lv_expr_1_0= ruleActionRef ) ) | ( (lv_block_2_0= ruleBlock ) ) ) ) ;
    public final EObject ruleActionFacet() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_expr_1_0 = null;

        EObject lv_block_2_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:4261:2: ( ( ( (lv_key_0_0= ruleActionFacetKey ) ) ( ( (lv_expr_1_0= ruleActionRef ) ) | ( (lv_block_2_0= ruleBlock ) ) ) ) )
            // InternalGaml.g:4262:2: ( ( (lv_key_0_0= ruleActionFacetKey ) ) ( ( (lv_expr_1_0= ruleActionRef ) ) | ( (lv_block_2_0= ruleBlock ) ) ) )
            {
            // InternalGaml.g:4262:2: ( ( (lv_key_0_0= ruleActionFacetKey ) ) ( ( (lv_expr_1_0= ruleActionRef ) ) | ( (lv_block_2_0= ruleBlock ) ) ) )
            // InternalGaml.g:4263:3: ( (lv_key_0_0= ruleActionFacetKey ) ) ( ( (lv_expr_1_0= ruleActionRef ) ) | ( (lv_block_2_0= ruleBlock ) ) )
            {
            // InternalGaml.g:4263:3: ( (lv_key_0_0= ruleActionFacetKey ) )
            // InternalGaml.g:4264:4: (lv_key_0_0= ruleActionFacetKey )
            {
            // InternalGaml.g:4264:4: (lv_key_0_0= ruleActionFacetKey )
            // InternalGaml.g:4265:5: lv_key_0_0= ruleActionFacetKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getActionFacetAccess().getKeyActionFacetKeyParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_38);
            lv_key_0_0=ruleActionFacetKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getActionFacetRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_0_0,
              						"gama.core.lang.Gaml.ActionFacetKey");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:4282:3: ( ( (lv_expr_1_0= ruleActionRef ) ) | ( (lv_block_2_0= ruleBlock ) ) )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_ID||LA73_0==38||(LA73_0>=40 && LA73_0<=87)) ) {
                alt73=1;
            }
            else if ( (LA73_0==34) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // InternalGaml.g:4283:4: ( (lv_expr_1_0= ruleActionRef ) )
                    {
                    // InternalGaml.g:4283:4: ( (lv_expr_1_0= ruleActionRef ) )
                    // InternalGaml.g:4284:5: (lv_expr_1_0= ruleActionRef )
                    {
                    // InternalGaml.g:4284:5: (lv_expr_1_0= ruleActionRef )
                    // InternalGaml.g:4285:6: lv_expr_1_0= ruleActionRef
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getActionFacetAccess().getExprActionRefParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_1_0=ruleActionRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getActionFacetRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_1_0,
                      							"gama.core.lang.Gaml.ActionRef");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:4303:4: ( (lv_block_2_0= ruleBlock ) )
                    {
                    // InternalGaml.g:4303:4: ( (lv_block_2_0= ruleBlock ) )
                    // InternalGaml.g:4304:5: (lv_block_2_0= ruleBlock )
                    {
                    // InternalGaml.g:4304:5: (lv_block_2_0= ruleBlock )
                    // InternalGaml.g:4305:6: lv_block_2_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getActionFacetAccess().getBlockBlockParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_2_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getActionFacetRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_2_0,
                      							"gama.core.lang.Gaml.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionFacet"


    // $ANTLR start "entryRuleBlock"
    // InternalGaml.g:4327:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalGaml.g:4327:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalGaml.g:4328:2: iv_ruleBlock= ruleBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlock=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalGaml.g:4334:1: ruleBlock returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:4340:2: ( ( () otherlv_1= '{' ( ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ) )
            // InternalGaml.g:4341:2: ( () otherlv_1= '{' ( ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            {
            // InternalGaml.g:4341:2: ( () otherlv_1= '{' ( ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // InternalGaml.g:4342:3: () otherlv_1= '{' ( ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // InternalGaml.g:4342:3: ()
            // InternalGaml.g:4343:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockAccess().getBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,34,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalGaml.g:4353:3: ( ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            // InternalGaml.g:4354:4: ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            // InternalGaml.g:4354:4: ( (lv_statements_2_0= ruleStatement ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( ((LA74_0>=RULE_ID && LA74_0<=RULE_KEYWORD)||(LA74_0>=23 && LA74_0<=24)||LA74_0==26||(LA74_0>=28 && LA74_0<=29)||LA74_0==31||(LA74_0>=33 && LA74_0<=34)||(LA74_0>=37 && LA74_0<=87)||(LA74_0>=95 && LA74_0<=118)||LA74_0==129||(LA74_0>=133 && LA74_0<=138)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalGaml.g:4355:5: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalGaml.g:4355:5: (lv_statements_2_0= ruleStatement )
            	    // InternalGaml.g:4356:6: lv_statements_2_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBlockRule());
            	      						}
            	      						add(
            	      							current,
            	      							"statements",
            	      							lv_statements_2_0,
            	      							"gama.core.lang.Gaml.Statement");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            otherlv_3=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_2_1());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleExpression"
    // InternalGaml.g:4382:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalGaml.g:4382:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalGaml.g:4383:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalGaml.g:4389:1: ruleExpression returns [EObject current=null] : ( ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=>this_ArgumentPair_0= ruleArgumentPair ) | this_Pair_1= rulePair ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ArgumentPair_0 = null;

        EObject this_Pair_1 = null;



        	enterRule();

        try {
            // InternalGaml.g:4395:2: ( ( ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=>this_ArgumentPair_0= ruleArgumentPair ) | this_Pair_1= rulePair ) )
            // InternalGaml.g:4396:2: ( ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=>this_ArgumentPair_0= ruleArgumentPair ) | this_Pair_1= rulePair )
            {
            // InternalGaml.g:4396:2: ( ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=>this_ArgumentPair_0= ruleArgumentPair ) | this_Pair_1= rulePair )
            int alt75=2;
            alt75 = dfa75.predict(input);
            switch (alt75) {
                case 1 :
                    // InternalGaml.g:4397:3: ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=>this_ArgumentPair_0= ruleArgumentPair )
                    {
                    // InternalGaml.g:4397:3: ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=>this_ArgumentPair_0= ruleArgumentPair )
                    // InternalGaml.g:4398:4: ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=>this_ArgumentPair_0= ruleArgumentPair
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getExpressionAccess().getArgumentPairParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_ArgumentPair_0=ruleArgumentPair();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ArgumentPair_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:4433:3: this_Pair_1= rulePair
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getPairParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Pair_1=rulePair();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Pair_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleArgumentPair"
    // InternalGaml.g:4445:1: entryRuleArgumentPair returns [EObject current=null] : iv_ruleArgumentPair= ruleArgumentPair EOF ;
    public final EObject entryRuleArgumentPair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentPair = null;


        try {
            // InternalGaml.g:4445:53: (iv_ruleArgumentPair= ruleArgumentPair EOF )
            // InternalGaml.g:4446:2: iv_ruleArgumentPair= ruleArgumentPair EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentPairRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArgumentPair=ruleArgumentPair();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentPair; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArgumentPair"


    // $ANTLR start "ruleArgumentPair"
    // InternalGaml.g:4452:1: ruleArgumentPair returns [EObject current=null] : ( ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=> ( ( ( (lv_op_0_0= ruleValid_ID ) ) otherlv_1= '::' ) | ( ( ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) ) ) otherlv_3= ':' ) ) )? ( (lv_right_4_0= rulePair ) ) ) ;
    public final EObject ruleArgumentPair() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_op_0_0 = null;

        AntlrDatatypeRuleToken lv_op_2_1 = null;

        AntlrDatatypeRuleToken lv_op_2_2 = null;

        AntlrDatatypeRuleToken lv_op_2_3 = null;

        AntlrDatatypeRuleToken lv_op_2_4 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:4458:2: ( ( ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=> ( ( ( (lv_op_0_0= ruleValid_ID ) ) otherlv_1= '::' ) | ( ( ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) ) ) otherlv_3= ':' ) ) )? ( (lv_right_4_0= rulePair ) ) ) )
            // InternalGaml.g:4459:2: ( ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=> ( ( ( (lv_op_0_0= ruleValid_ID ) ) otherlv_1= '::' ) | ( ( ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) ) ) otherlv_3= ':' ) ) )? ( (lv_right_4_0= rulePair ) ) )
            {
            // InternalGaml.g:4459:2: ( ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=> ( ( ( (lv_op_0_0= ruleValid_ID ) ) otherlv_1= '::' ) | ( ( ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) ) ) otherlv_3= ':' ) ) )? ( (lv_right_4_0= rulePair ) ) )
            // InternalGaml.g:4460:3: ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=> ( ( ( (lv_op_0_0= ruleValid_ID ) ) otherlv_1= '::' ) | ( ( ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) ) ) otherlv_3= ':' ) ) )? ( (lv_right_4_0= rulePair ) )
            {
            // InternalGaml.g:4460:3: ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=> ( ( ( (lv_op_0_0= ruleValid_ID ) ) otherlv_1= '::' ) | ( ( ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) ) ) otherlv_3= ':' ) ) )?
            int alt78=2;
            alt78 = dfa78.predict(input);
            switch (alt78) {
                case 1 :
                    // InternalGaml.g:4461:4: ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=> ( ( ( (lv_op_0_0= ruleValid_ID ) ) otherlv_1= '::' ) | ( ( ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) ) ) otherlv_3= ':' ) )
                    {
                    // InternalGaml.g:4486:4: ( ( ( (lv_op_0_0= ruleValid_ID ) ) otherlv_1= '::' ) | ( ( ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) ) ) otherlv_3= ':' ) )
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==RULE_ID||LA77_0==38||(LA77_0>=40 && LA77_0<=87)) ) {
                        alt77=1;
                    }
                    else if ( (LA77_0==29||(LA77_0>=95 && LA77_0<=118)) ) {
                        alt77=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 77, 0, input);

                        throw nvae;
                    }
                    switch (alt77) {
                        case 1 :
                            // InternalGaml.g:4487:5: ( ( (lv_op_0_0= ruleValid_ID ) ) otherlv_1= '::' )
                            {
                            // InternalGaml.g:4487:5: ( ( (lv_op_0_0= ruleValid_ID ) ) otherlv_1= '::' )
                            // InternalGaml.g:4488:6: ( (lv_op_0_0= ruleValid_ID ) ) otherlv_1= '::'
                            {
                            // InternalGaml.g:4488:6: ( (lv_op_0_0= ruleValid_ID ) )
                            // InternalGaml.g:4489:7: (lv_op_0_0= ruleValid_ID )
                            {
                            // InternalGaml.g:4489:7: (lv_op_0_0= ruleValid_ID )
                            // InternalGaml.g:4490:8: lv_op_0_0= ruleValid_ID
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getArgumentPairAccess().getOpValid_IDParserRuleCall_0_0_0_0_0());
                              							
                            }
                            pushFollow(FOLLOW_40);
                            lv_op_0_0=ruleValid_ID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getArgumentPairRule());
                              								}
                              								set(
                              									current,
                              									"op",
                              									lv_op_0_0,
                              									"gama.core.lang.Gaml.Valid_ID");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            otherlv_1=(Token)match(input,120,FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_1, grammarAccess.getArgumentPairAccess().getColonColonKeyword_0_0_0_1());
                              					
                            }

                            }


                            }
                            break;
                        case 2 :
                            // InternalGaml.g:4513:5: ( ( ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) ) ) otherlv_3= ':' )
                            {
                            // InternalGaml.g:4513:5: ( ( ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) ) ) otherlv_3= ':' )
                            // InternalGaml.g:4514:6: ( ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) ) ) otherlv_3= ':'
                            {
                            // InternalGaml.g:4514:6: ( ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) ) )
                            // InternalGaml.g:4515:7: ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) )
                            {
                            // InternalGaml.g:4515:7: ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) )
                            // InternalGaml.g:4516:8: (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey )
                            {
                            // InternalGaml.g:4516:8: (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey )
                            int alt76=4;
                            switch ( input.LA(1) ) {
                            case 95:
                            case 96:
                                {
                                alt76=1;
                                }
                                break;
                            case 97:
                            case 98:
                            case 99:
                            case 100:
                            case 101:
                                {
                                alt76=2;
                                }
                                break;
                            case 29:
                            case 102:
                            case 103:
                            case 104:
                            case 105:
                            case 106:
                            case 107:
                            case 108:
                            case 109:
                            case 110:
                            case 111:
                            case 112:
                            case 113:
                            case 114:
                            case 115:
                            case 116:
                                {
                                alt76=3;
                                }
                                break;
                            case 117:
                            case 118:
                                {
                                alt76=4;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 76, 0, input);

                                throw nvae;
                            }

                            switch (alt76) {
                                case 1 :
                                    // InternalGaml.g:4517:9: lv_op_2_1= ruleDefinitionFacetKey
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getArgumentPairAccess().getOpDefinitionFacetKeyParserRuleCall_0_0_1_0_0_0());
                                      								
                                    }
                                    pushFollow(FOLLOW_24);
                                    lv_op_2_1=ruleDefinitionFacetKey();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getArgumentPairRule());
                                      									}
                                      									set(
                                      										current,
                                      										"op",
                                      										lv_op_2_1,
                                      										"gama.core.lang.Gaml.DefinitionFacetKey");
                                      									afterParserOrEnumRuleCall();
                                      								
                                    }

                                    }
                                    break;
                                case 2 :
                                    // InternalGaml.g:4533:9: lv_op_2_2= ruleTypeFacetKey
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getArgumentPairAccess().getOpTypeFacetKeyParserRuleCall_0_0_1_0_0_1());
                                      								
                                    }
                                    pushFollow(FOLLOW_24);
                                    lv_op_2_2=ruleTypeFacetKey();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getArgumentPairRule());
                                      									}
                                      									set(
                                      										current,
                                      										"op",
                                      										lv_op_2_2,
                                      										"gama.core.lang.Gaml.TypeFacetKey");
                                      									afterParserOrEnumRuleCall();
                                      								
                                    }

                                    }
                                    break;
                                case 3 :
                                    // InternalGaml.g:4549:9: lv_op_2_3= ruleSpecialFacetKey
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getArgumentPairAccess().getOpSpecialFacetKeyParserRuleCall_0_0_1_0_0_2());
                                      								
                                    }
                                    pushFollow(FOLLOW_24);
                                    lv_op_2_3=ruleSpecialFacetKey();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getArgumentPairRule());
                                      									}
                                      									set(
                                      										current,
                                      										"op",
                                      										lv_op_2_3,
                                      										"gama.core.lang.Gaml.SpecialFacetKey");
                                      									afterParserOrEnumRuleCall();
                                      								
                                    }

                                    }
                                    break;
                                case 4 :
                                    // InternalGaml.g:4565:9: lv_op_2_4= ruleActionFacetKey
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getArgumentPairAccess().getOpActionFacetKeyParserRuleCall_0_0_1_0_0_3());
                                      								
                                    }
                                    pushFollow(FOLLOW_24);
                                    lv_op_2_4=ruleActionFacetKey();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getArgumentPairRule());
                                      									}
                                      									set(
                                      										current,
                                      										"op",
                                      										lv_op_2_4,
                                      										"gama.core.lang.Gaml.ActionFacetKey");
                                      									afterParserOrEnumRuleCall();
                                      								
                                    }

                                    }
                                    break;

                            }


                            }


                            }

                            otherlv_3=(Token)match(input,30,FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_3, grammarAccess.getArgumentPairAccess().getColonKeyword_0_0_1_1());
                              					
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalGaml.g:4590:3: ( (lv_right_4_0= rulePair ) )
            // InternalGaml.g:4591:4: (lv_right_4_0= rulePair )
            {
            // InternalGaml.g:4591:4: (lv_right_4_0= rulePair )
            // InternalGaml.g:4592:5: lv_right_4_0= rulePair
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArgumentPairAccess().getRightPairParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_right_4_0=rulePair();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArgumentPairRule());
              					}
              					set(
              						current,
              						"right",
              						lv_right_4_0,
              						"gama.core.lang.Gaml.Pair");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArgumentPair"


    // $ANTLR start "entryRulePair"
    // InternalGaml.g:4613:1: entryRulePair returns [EObject current=null] : iv_rulePair= rulePair EOF ;
    public final EObject entryRulePair() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePair = null;


        try {
            // InternalGaml.g:4613:45: (iv_rulePair= rulePair EOF )
            // InternalGaml.g:4614:2: iv_rulePair= rulePair EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPairRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePair=rulePair();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePair; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePair"


    // $ANTLR start "rulePair"
    // InternalGaml.g:4620:1: rulePair returns [EObject current=null] : (this_If_0= ruleIf ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleIf ) ) )? ) ;
    public final EObject rulePair() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_If_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:4626:2: ( (this_If_0= ruleIf ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleIf ) ) )? ) )
            // InternalGaml.g:4627:2: (this_If_0= ruleIf ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleIf ) ) )? )
            {
            // InternalGaml.g:4627:2: (this_If_0= ruleIf ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleIf ) ) )? )
            // InternalGaml.g:4628:3: this_If_0= ruleIf ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleIf ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPairAccess().getIfParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_41);
            this_If_0=ruleIf();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_If_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalGaml.g:4636:3: ( () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleIf ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==120) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalGaml.g:4637:4: () ( (lv_op_2_0= '::' ) ) ( (lv_right_3_0= ruleIf ) )
                    {
                    // InternalGaml.g:4637:4: ()
                    // InternalGaml.g:4638:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getPairAccess().getBinaryOperatorLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalGaml.g:4644:4: ( (lv_op_2_0= '::' ) )
                    // InternalGaml.g:4645:5: (lv_op_2_0= '::' )
                    {
                    // InternalGaml.g:4645:5: (lv_op_2_0= '::' )
                    // InternalGaml.g:4646:6: lv_op_2_0= '::'
                    {
                    lv_op_2_0=(Token)match(input,120,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_0, grammarAccess.getPairAccess().getOpColonColonKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPairRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_0, "::");
                      					
                    }

                    }


                    }

                    // InternalGaml.g:4658:4: ( (lv_right_3_0= ruleIf ) )
                    // InternalGaml.g:4659:5: (lv_right_3_0= ruleIf )
                    {
                    // InternalGaml.g:4659:5: (lv_right_3_0= ruleIf )
                    // InternalGaml.g:4660:6: lv_right_3_0= ruleIf
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPairAccess().getRightIfParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleIf();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPairRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"gama.core.lang.Gaml.If");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePair"


    // $ANTLR start "entryRuleIf"
    // InternalGaml.g:4682:1: entryRuleIf returns [EObject current=null] : iv_ruleIf= ruleIf EOF ;
    public final EObject entryRuleIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIf = null;


        try {
            // InternalGaml.g:4682:43: (iv_ruleIf= ruleIf EOF )
            // InternalGaml.g:4683:2: iv_ruleIf= ruleIf EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIf=ruleIf();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIf; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIf"


    // $ANTLR start "ruleIf"
    // InternalGaml.g:4689:1: ruleIf returns [EObject current=null] : (this_Or_0= ruleOr ( () ( (lv_op_2_0= '?' ) ) ( (lv_right_3_0= ruleOr ) ) (otherlv_4= ':' ( (lv_ifFalse_5_0= ruleOr ) ) ) )? ) ;
    public final EObject ruleIf() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token otherlv_4=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_ifFalse_5_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:4695:2: ( (this_Or_0= ruleOr ( () ( (lv_op_2_0= '?' ) ) ( (lv_right_3_0= ruleOr ) ) (otherlv_4= ':' ( (lv_ifFalse_5_0= ruleOr ) ) ) )? ) )
            // InternalGaml.g:4696:2: (this_Or_0= ruleOr ( () ( (lv_op_2_0= '?' ) ) ( (lv_right_3_0= ruleOr ) ) (otherlv_4= ':' ( (lv_ifFalse_5_0= ruleOr ) ) ) )? )
            {
            // InternalGaml.g:4696:2: (this_Or_0= ruleOr ( () ( (lv_op_2_0= '?' ) ) ( (lv_right_3_0= ruleOr ) ) (otherlv_4= ':' ( (lv_ifFalse_5_0= ruleOr ) ) ) )? )
            // InternalGaml.g:4697:3: this_Or_0= ruleOr ( () ( (lv_op_2_0= '?' ) ) ( (lv_right_3_0= ruleOr ) ) (otherlv_4= ':' ( (lv_ifFalse_5_0= ruleOr ) ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getIfAccess().getOrParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_42);
            this_Or_0=ruleOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Or_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalGaml.g:4705:3: ( () ( (lv_op_2_0= '?' ) ) ( (lv_right_3_0= ruleOr ) ) (otherlv_4= ':' ( (lv_ifFalse_5_0= ruleOr ) ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==121) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalGaml.g:4706:4: () ( (lv_op_2_0= '?' ) ) ( (lv_right_3_0= ruleOr ) ) (otherlv_4= ':' ( (lv_ifFalse_5_0= ruleOr ) ) )
                    {
                    // InternalGaml.g:4706:4: ()
                    // InternalGaml.g:4707:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getIfAccess().getIfLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalGaml.g:4713:4: ( (lv_op_2_0= '?' ) )
                    // InternalGaml.g:4714:5: (lv_op_2_0= '?' )
                    {
                    // InternalGaml.g:4714:5: (lv_op_2_0= '?' )
                    // InternalGaml.g:4715:6: lv_op_2_0= '?'
                    {
                    lv_op_2_0=(Token)match(input,121,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_0, grammarAccess.getIfAccess().getOpQuestionMarkKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIfRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_2_0, "?");
                      					
                    }

                    }


                    }

                    // InternalGaml.g:4727:4: ( (lv_right_3_0= ruleOr ) )
                    // InternalGaml.g:4728:5: (lv_right_3_0= ruleOr )
                    {
                    // InternalGaml.g:4728:5: (lv_right_3_0= ruleOr )
                    // InternalGaml.g:4729:6: lv_right_3_0= ruleOr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfAccess().getRightOrParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
                    lv_right_3_0=ruleOr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"gama.core.lang.Gaml.Or");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalGaml.g:4746:4: (otherlv_4= ':' ( (lv_ifFalse_5_0= ruleOr ) ) )
                    // InternalGaml.g:4747:5: otherlv_4= ':' ( (lv_ifFalse_5_0= ruleOr ) )
                    {
                    otherlv_4=(Token)match(input,30,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getIfAccess().getColonKeyword_1_3_0());
                      				
                    }
                    // InternalGaml.g:4751:5: ( (lv_ifFalse_5_0= ruleOr ) )
                    // InternalGaml.g:4752:6: (lv_ifFalse_5_0= ruleOr )
                    {
                    // InternalGaml.g:4752:6: (lv_ifFalse_5_0= ruleOr )
                    // InternalGaml.g:4753:7: lv_ifFalse_5_0= ruleOr
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getIfAccess().getIfFalseOrParserRuleCall_1_3_1_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_ifFalse_5_0=ruleOr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getIfRule());
                      							}
                      							set(
                      								current,
                      								"ifFalse",
                      								lv_ifFalse_5_0,
                      								"gama.core.lang.Gaml.Or");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIf"


    // $ANTLR start "entryRuleOr"
    // InternalGaml.g:4776:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalGaml.g:4776:43: (iv_ruleOr= ruleOr EOF )
            // InternalGaml.g:4777:2: iv_ruleOr= ruleOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOr=ruleOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalGaml.g:4783:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:4789:2: ( (this_And_0= ruleAnd ( () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalGaml.g:4790:2: (this_And_0= ruleAnd ( () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalGaml.g:4790:2: (this_And_0= ruleAnd ( () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalGaml.g:4791:3: this_And_0= ruleAnd ( () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAnd ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_43);
            this_And_0=ruleAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_And_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalGaml.g:4799:3: ( () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAnd ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==122) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalGaml.g:4800:4: () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalGaml.g:4800:4: ()
            	    // InternalGaml.g:4801:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrAccess().getBinaryOperatorLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalGaml.g:4807:4: ( (lv_op_2_0= 'or' ) )
            	    // InternalGaml.g:4808:5: (lv_op_2_0= 'or' )
            	    {
            	    // InternalGaml.g:4808:5: (lv_op_2_0= 'or' )
            	    // InternalGaml.g:4809:6: lv_op_2_0= 'or'
            	    {
            	    lv_op_2_0=(Token)match(input,122,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getOrAccess().getOpOrKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getOrRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "or");
            	      					
            	    }

            	    }


            	    }

            	    // InternalGaml.g:4821:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalGaml.g:4822:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalGaml.g:4822:5: (lv_right_3_0= ruleAnd )
            	    // InternalGaml.g:4823:6: lv_right_3_0= ruleAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_43);
            	    lv_right_3_0=ruleAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getOrRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"gama.core.lang.Gaml.And");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalGaml.g:4845:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalGaml.g:4845:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalGaml.g:4846:2: iv_ruleAnd= ruleAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnd; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalGaml.g:4852:1: ruleAnd returns [EObject current=null] : (this_Cast_0= ruleCast ( () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleCast ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_Cast_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:4858:2: ( (this_Cast_0= ruleCast ( () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleCast ) ) )* ) )
            // InternalGaml.g:4859:2: (this_Cast_0= ruleCast ( () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleCast ) ) )* )
            {
            // InternalGaml.g:4859:2: (this_Cast_0= ruleCast ( () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleCast ) ) )* )
            // InternalGaml.g:4860:3: this_Cast_0= ruleCast ( () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleCast ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndAccess().getCastParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_44);
            this_Cast_0=ruleCast();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Cast_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalGaml.g:4868:3: ( () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleCast ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==123) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalGaml.g:4869:4: () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleCast ) )
            	    {
            	    // InternalGaml.g:4869:4: ()
            	    // InternalGaml.g:4870:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndAccess().getBinaryOperatorLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalGaml.g:4876:4: ( (lv_op_2_0= 'and' ) )
            	    // InternalGaml.g:4877:5: (lv_op_2_0= 'and' )
            	    {
            	    // InternalGaml.g:4877:5: (lv_op_2_0= 'and' )
            	    // InternalGaml.g:4878:6: lv_op_2_0= 'and'
            	    {
            	    lv_op_2_0=(Token)match(input,123,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getAndAccess().getOpAndKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getAndRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "and");
            	      					
            	    }

            	    }


            	    }

            	    // InternalGaml.g:4890:4: ( (lv_right_3_0= ruleCast ) )
            	    // InternalGaml.g:4891:5: (lv_right_3_0= ruleCast )
            	    {
            	    // InternalGaml.g:4891:5: (lv_right_3_0= ruleCast )
            	    // InternalGaml.g:4892:6: lv_right_3_0= ruleCast
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndAccess().getRightCastParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_44);
            	    lv_right_3_0=ruleCast();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAndRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"gama.core.lang.Gaml.Cast");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleCast"
    // InternalGaml.g:4914:1: entryRuleCast returns [EObject current=null] : iv_ruleCast= ruleCast EOF ;
    public final EObject entryRuleCast() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCast = null;


        try {
            // InternalGaml.g:4914:45: (iv_ruleCast= ruleCast EOF )
            // InternalGaml.g:4915:2: iv_ruleCast= ruleCast EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCastRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCast=ruleCast();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCast; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCast"


    // $ANTLR start "ruleCast"
    // InternalGaml.g:4921:1: ruleCast returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( () ( (lv_op_2_0= 'as' ) ) ) ( ( (lv_right_3_0= ruleTypeRef ) ) | (otherlv_4= '(' ( (lv_right_5_0= ruleTypeRef ) ) otherlv_6= ')' ) ) )? ) ;
    public final EObject ruleCast() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:4927:2: ( (this_Comparison_0= ruleComparison ( ( () ( (lv_op_2_0= 'as' ) ) ) ( ( (lv_right_3_0= ruleTypeRef ) ) | (otherlv_4= '(' ( (lv_right_5_0= ruleTypeRef ) ) otherlv_6= ')' ) ) )? ) )
            // InternalGaml.g:4928:2: (this_Comparison_0= ruleComparison ( ( () ( (lv_op_2_0= 'as' ) ) ) ( ( (lv_right_3_0= ruleTypeRef ) ) | (otherlv_4= '(' ( (lv_right_5_0= ruleTypeRef ) ) otherlv_6= ')' ) ) )? )
            {
            // InternalGaml.g:4928:2: (this_Comparison_0= ruleComparison ( ( () ( (lv_op_2_0= 'as' ) ) ) ( ( (lv_right_3_0= ruleTypeRef ) ) | (otherlv_4= '(' ( (lv_right_5_0= ruleTypeRef ) ) otherlv_6= ')' ) ) )? )
            // InternalGaml.g:4929:3: this_Comparison_0= ruleComparison ( ( () ( (lv_op_2_0= 'as' ) ) ) ( ( (lv_right_3_0= ruleTypeRef ) ) | (otherlv_4= '(' ( (lv_right_5_0= ruleTypeRef ) ) otherlv_6= ')' ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCastAccess().getComparisonParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_11);
            this_Comparison_0=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Comparison_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalGaml.g:4937:3: ( ( () ( (lv_op_2_0= 'as' ) ) ) ( ( (lv_right_3_0= ruleTypeRef ) ) | (otherlv_4= '(' ( (lv_right_5_0= ruleTypeRef ) ) otherlv_6= ')' ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==18) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalGaml.g:4938:4: ( () ( (lv_op_2_0= 'as' ) ) ) ( ( (lv_right_3_0= ruleTypeRef ) ) | (otherlv_4= '(' ( (lv_right_5_0= ruleTypeRef ) ) otherlv_6= ')' ) )
                    {
                    // InternalGaml.g:4938:4: ( () ( (lv_op_2_0= 'as' ) ) )
                    // InternalGaml.g:4939:5: () ( (lv_op_2_0= 'as' ) )
                    {
                    // InternalGaml.g:4939:5: ()
                    // InternalGaml.g:4940:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndSet(
                      							grammarAccess.getCastAccess().getBinaryOperatorLeftAction_1_0_0(),
                      							current);
                      					
                    }

                    }

                    // InternalGaml.g:4946:5: ( (lv_op_2_0= 'as' ) )
                    // InternalGaml.g:4947:6: (lv_op_2_0= 'as' )
                    {
                    // InternalGaml.g:4947:6: (lv_op_2_0= 'as' )
                    // InternalGaml.g:4948:7: lv_op_2_0= 'as'
                    {
                    lv_op_2_0=(Token)match(input,18,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_op_2_0, grammarAccess.getCastAccess().getOpAsKeyword_1_0_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getCastRule());
                      							}
                      							setWithLastConsumed(current, "op", lv_op_2_0, "as");
                      						
                    }

                    }


                    }


                    }

                    // InternalGaml.g:4961:4: ( ( (lv_right_3_0= ruleTypeRef ) ) | (otherlv_4= '(' ( (lv_right_5_0= ruleTypeRef ) ) otherlv_6= ')' ) )
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==RULE_ID||LA83_0==40) ) {
                        alt83=1;
                    }
                    else if ( (LA83_0==31) ) {
                        alt83=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 83, 0, input);

                        throw nvae;
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalGaml.g:4962:5: ( (lv_right_3_0= ruleTypeRef ) )
                            {
                            // InternalGaml.g:4962:5: ( (lv_right_3_0= ruleTypeRef ) )
                            // InternalGaml.g:4963:6: (lv_right_3_0= ruleTypeRef )
                            {
                            // InternalGaml.g:4963:6: (lv_right_3_0= ruleTypeRef )
                            // InternalGaml.g:4964:7: lv_right_3_0= ruleTypeRef
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getCastAccess().getRightTypeRefParserRuleCall_1_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_right_3_0=ruleTypeRef();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getCastRule());
                              							}
                              							set(
                              								current,
                              								"right",
                              								lv_right_3_0,
                              								"gama.core.lang.Gaml.TypeRef");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalGaml.g:4982:5: (otherlv_4= '(' ( (lv_right_5_0= ruleTypeRef ) ) otherlv_6= ')' )
                            {
                            // InternalGaml.g:4982:5: (otherlv_4= '(' ( (lv_right_5_0= ruleTypeRef ) ) otherlv_6= ')' )
                            // InternalGaml.g:4983:6: otherlv_4= '(' ( (lv_right_5_0= ruleTypeRef ) ) otherlv_6= ')'
                            {
                            otherlv_4=(Token)match(input,31,FOLLOW_26); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_4, grammarAccess.getCastAccess().getLeftParenthesisKeyword_1_1_1_0());
                              					
                            }
                            // InternalGaml.g:4987:6: ( (lv_right_5_0= ruleTypeRef ) )
                            // InternalGaml.g:4988:7: (lv_right_5_0= ruleTypeRef )
                            {
                            // InternalGaml.g:4988:7: (lv_right_5_0= ruleTypeRef )
                            // InternalGaml.g:4989:8: lv_right_5_0= ruleTypeRef
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getCastAccess().getRightTypeRefParserRuleCall_1_1_1_1_0());
                              							
                            }
                            pushFollow(FOLLOW_27);
                            lv_right_5_0=ruleTypeRef();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getCastRule());
                              								}
                              								set(
                              									current,
                              									"right",
                              									lv_right_5_0,
                              									"gama.core.lang.Gaml.TypeRef");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            otherlv_6=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_6, grammarAccess.getCastAccess().getRightParenthesisKeyword_1_1_1_2());
                              					
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCast"


    // $ANTLR start "entryRuleComparison"
    // InternalGaml.g:5017:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalGaml.g:5017:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalGaml.g:5018:2: iv_ruleComparison= ruleComparison EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparison; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalGaml.g:5024:1: ruleComparison returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )? ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        Token lv_op_2_5=null;
        Token lv_op_2_6=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:5030:2: ( (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )? ) )
            // InternalGaml.g:5031:2: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )? )
            {
            // InternalGaml.g:5031:2: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )? )
            // InternalGaml.g:5032:3: this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_46);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalGaml.g:5040:3: ( ( () ( ( (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==36||(LA86_0>=124 && LA86_0<=127)) ) {
                alt86=1;
            }
            else if ( (LA86_0==89) ) {
                int LA86_2 = input.LA(2);

                if ( ((LA86_2>=RULE_ID && LA86_2<=RULE_KEYWORD)||LA86_2==31||LA86_2==34||LA86_2==38||(LA86_2>=40 && LA86_2<=87)||LA86_2==129||(LA86_2>=133 && LA86_2<=138)) ) {
                    alt86=1;
                }
            }
            switch (alt86) {
                case 1 :
                    // InternalGaml.g:5041:4: ( () ( ( (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' ) ) ) ) ( (lv_right_3_0= ruleAddition ) )
                    {
                    // InternalGaml.g:5041:4: ( () ( ( (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' ) ) ) )
                    // InternalGaml.g:5042:5: () ( ( (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' ) ) )
                    {
                    // InternalGaml.g:5042:5: ()
                    // InternalGaml.g:5043:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndSet(
                      							grammarAccess.getComparisonAccess().getBinaryOperatorLeftAction_1_0_0(),
                      							current);
                      					
                    }

                    }

                    // InternalGaml.g:5049:5: ( ( (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' ) ) )
                    // InternalGaml.g:5050:6: ( (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' ) )
                    {
                    // InternalGaml.g:5050:6: ( (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' ) )
                    // InternalGaml.g:5051:7: (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' )
                    {
                    // InternalGaml.g:5051:7: (lv_op_2_1= '!=' | lv_op_2_2= '=' | lv_op_2_3= '>=' | lv_op_2_4= '<=' | lv_op_2_5= '<' | lv_op_2_6= '>' )
                    int alt85=6;
                    switch ( input.LA(1) ) {
                    case 124:
                        {
                        alt85=1;
                        }
                        break;
                    case 36:
                        {
                        alt85=2;
                        }
                        break;
                    case 125:
                        {
                        alt85=3;
                        }
                        break;
                    case 126:
                        {
                        alt85=4;
                        }
                        break;
                    case 127:
                        {
                        alt85=5;
                        }
                        break;
                    case 89:
                        {
                        alt85=6;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 85, 0, input);

                        throw nvae;
                    }

                    switch (alt85) {
                        case 1 :
                            // InternalGaml.g:5052:8: lv_op_2_1= '!='
                            {
                            lv_op_2_1=(Token)match(input,124,FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_1, grammarAccess.getComparisonAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getComparisonRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_1, null);
                              							
                            }

                            }
                            break;
                        case 2 :
                            // InternalGaml.g:5063:8: lv_op_2_2= '='
                            {
                            lv_op_2_2=(Token)match(input,36,FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_2, grammarAccess.getComparisonAccess().getOpEqualsSignKeyword_1_0_1_0_1());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getComparisonRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_2, null);
                              							
                            }

                            }
                            break;
                        case 3 :
                            // InternalGaml.g:5074:8: lv_op_2_3= '>='
                            {
                            lv_op_2_3=(Token)match(input,125,FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_3, grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_1_0_2());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getComparisonRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_3, null);
                              							
                            }

                            }
                            break;
                        case 4 :
                            // InternalGaml.g:5085:8: lv_op_2_4= '<='
                            {
                            lv_op_2_4=(Token)match(input,126,FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_4, grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_0_1_0_3());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getComparisonRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_4, null);
                              							
                            }

                            }
                            break;
                        case 5 :
                            // InternalGaml.g:5096:8: lv_op_2_5= '<'
                            {
                            lv_op_2_5=(Token)match(input,127,FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_5, grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_0_1_0_4());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getComparisonRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_5, null);
                              							
                            }

                            }
                            break;
                        case 6 :
                            // InternalGaml.g:5107:8: lv_op_2_6= '>'
                            {
                            lv_op_2_6=(Token)match(input,89,FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_6, grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_0_1_0_5());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getComparisonRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_6, null);
                              							
                            }

                            }
                            break;

                    }


                    }


                    }


                    }

                    // InternalGaml.g:5121:4: ( (lv_right_3_0= ruleAddition ) )
                    // InternalGaml.g:5122:5: (lv_right_3_0= ruleAddition )
                    {
                    // InternalGaml.g:5122:5: (lv_right_3_0= ruleAddition )
                    // InternalGaml.g:5123:6: lv_right_3_0= ruleAddition
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleAddition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getComparisonRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"gama.core.lang.Gaml.Addition");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleAddition"
    // InternalGaml.g:5145:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalGaml.g:5145:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalGaml.g:5146:2: iv_ruleAddition= ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAddition=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // InternalGaml.g:5152:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ( (lv_right_3_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:5158:2: ( (this_Multiplication_0= ruleMultiplication ( ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ( (lv_right_3_0= ruleMultiplication ) ) )* ) )
            // InternalGaml.g:5159:2: (this_Multiplication_0= ruleMultiplication ( ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ( (lv_right_3_0= ruleMultiplication ) ) )* )
            {
            // InternalGaml.g:5159:2: (this_Multiplication_0= ruleMultiplication ( ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ( (lv_right_3_0= ruleMultiplication ) ) )* )
            // InternalGaml.g:5160:3: this_Multiplication_0= ruleMultiplication ( ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ( (lv_right_3_0= ruleMultiplication ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_47);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Multiplication_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalGaml.g:5168:3: ( ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ( (lv_right_3_0= ruleMultiplication ) ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( ((LA88_0>=128 && LA88_0<=129)) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalGaml.g:5169:4: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ) ( (lv_right_3_0= ruleMultiplication ) )
            	    {
            	    // InternalGaml.g:5169:4: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) )
            	    // InternalGaml.g:5170:5: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
            	    {
            	    // InternalGaml.g:5170:5: ()
            	    // InternalGaml.g:5171:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getAdditionAccess().getBinaryOperatorLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalGaml.g:5177:5: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
            	    // InternalGaml.g:5178:6: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
            	    {
            	    // InternalGaml.g:5178:6: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
            	    // InternalGaml.g:5179:7: (lv_op_2_1= '+' | lv_op_2_2= '-' )
            	    {
            	    // InternalGaml.g:5179:7: (lv_op_2_1= '+' | lv_op_2_2= '-' )
            	    int alt87=2;
            	    int LA87_0 = input.LA(1);

            	    if ( (LA87_0==128) ) {
            	        alt87=1;
            	    }
            	    else if ( (LA87_0==129) ) {
            	        alt87=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 87, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt87) {
            	        case 1 :
            	            // InternalGaml.g:5180:8: lv_op_2_1= '+'
            	            {
            	            lv_op_2_1=(Token)match(input,128,FOLLOW_5); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getAdditionAccess().getOpPlusSignKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getAdditionRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalGaml.g:5191:8: lv_op_2_2= '-'
            	            {
            	            lv_op_2_2=(Token)match(input,129,FOLLOW_5); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getAdditionAccess().getOpHyphenMinusKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getAdditionRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // InternalGaml.g:5205:4: ( (lv_right_3_0= ruleMultiplication ) )
            	    // InternalGaml.g:5206:5: (lv_right_3_0= ruleMultiplication )
            	    {
            	    // InternalGaml.g:5206:5: (lv_right_3_0= ruleMultiplication )
            	    // InternalGaml.g:5207:6: lv_right_3_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_47);
            	    lv_right_3_0=ruleMultiplication();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"gama.core.lang.Gaml.Multiplication");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalGaml.g:5229:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalGaml.g:5229:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalGaml.g:5230:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // InternalGaml.g:5236:1: ruleMultiplication returns [EObject current=null] : (this_Exponentiation_0= ruleExponentiation ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExponentiation ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Exponentiation_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:5242:2: ( (this_Exponentiation_0= ruleExponentiation ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExponentiation ) ) )* ) )
            // InternalGaml.g:5243:2: (this_Exponentiation_0= ruleExponentiation ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExponentiation ) ) )* )
            {
            // InternalGaml.g:5243:2: (this_Exponentiation_0= ruleExponentiation ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExponentiation ) ) )* )
            // InternalGaml.g:5244:3: this_Exponentiation_0= ruleExponentiation ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExponentiation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicationAccess().getExponentiationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_48);
            this_Exponentiation_0=ruleExponentiation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Exponentiation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalGaml.g:5252:3: ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExponentiation ) ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( ((LA90_0>=130 && LA90_0<=131)) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalGaml.g:5253:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExponentiation ) )
            	    {
            	    // InternalGaml.g:5253:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) )
            	    // InternalGaml.g:5254:5: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    {
            	    // InternalGaml.g:5254:5: ()
            	    // InternalGaml.g:5255:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getMultiplicationAccess().getBinaryOperatorLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalGaml.g:5261:5: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    // InternalGaml.g:5262:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    {
            	    // InternalGaml.g:5262:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    // InternalGaml.g:5263:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    {
            	    // InternalGaml.g:5263:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    int alt89=2;
            	    int LA89_0 = input.LA(1);

            	    if ( (LA89_0==130) ) {
            	        alt89=1;
            	    }
            	    else if ( (LA89_0==131) ) {
            	        alt89=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 89, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt89) {
            	        case 1 :
            	            // InternalGaml.g:5264:8: lv_op_2_1= '*'
            	            {
            	            lv_op_2_1=(Token)match(input,130,FOLLOW_5); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getMultiplicationAccess().getOpAsteriskKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getMultiplicationRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalGaml.g:5275:8: lv_op_2_2= '/'
            	            {
            	            lv_op_2_2=(Token)match(input,131,FOLLOW_5); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getMultiplicationAccess().getOpSolidusKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getMultiplicationRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // InternalGaml.g:5289:4: ( (lv_right_3_0= ruleExponentiation ) )
            	    // InternalGaml.g:5290:5: (lv_right_3_0= ruleExponentiation )
            	    {
            	    // InternalGaml.g:5290:5: (lv_right_3_0= ruleExponentiation )
            	    // InternalGaml.g:5291:6: lv_right_3_0= ruleExponentiation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightExponentiationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_48);
            	    lv_right_3_0=ruleExponentiation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"gama.core.lang.Gaml.Exponentiation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleExponentiation"
    // InternalGaml.g:5313:1: entryRuleExponentiation returns [EObject current=null] : iv_ruleExponentiation= ruleExponentiation EOF ;
    public final EObject entryRuleExponentiation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExponentiation = null;


        try {
            // InternalGaml.g:5313:55: (iv_ruleExponentiation= ruleExponentiation EOF )
            // InternalGaml.g:5314:2: iv_ruleExponentiation= ruleExponentiation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExponentiationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExponentiation=ruleExponentiation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExponentiation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExponentiation"


    // $ANTLR start "ruleExponentiation"
    // InternalGaml.g:5320:1: ruleExponentiation returns [EObject current=null] : (this_Binary_0= ruleBinary ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= ruleBinary ) ) )* ) ;
    public final EObject ruleExponentiation() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_Binary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:5326:2: ( (this_Binary_0= ruleBinary ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= ruleBinary ) ) )* ) )
            // InternalGaml.g:5327:2: (this_Binary_0= ruleBinary ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= ruleBinary ) ) )* )
            {
            // InternalGaml.g:5327:2: (this_Binary_0= ruleBinary ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= ruleBinary ) ) )* )
            // InternalGaml.g:5328:3: this_Binary_0= ruleBinary ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= ruleBinary ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExponentiationAccess().getBinaryParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_49);
            this_Binary_0=ruleBinary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Binary_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalGaml.g:5336:3: ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= ruleBinary ) ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==132) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalGaml.g:5337:4: ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= ruleBinary ) )
            	    {
            	    // InternalGaml.g:5337:4: ( () ( (lv_op_2_0= '^' ) ) )
            	    // InternalGaml.g:5338:5: () ( (lv_op_2_0= '^' ) )
            	    {
            	    // InternalGaml.g:5338:5: ()
            	    // InternalGaml.g:5339:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getExponentiationAccess().getBinaryOperatorLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalGaml.g:5345:5: ( (lv_op_2_0= '^' ) )
            	    // InternalGaml.g:5346:6: (lv_op_2_0= '^' )
            	    {
            	    // InternalGaml.g:5346:6: (lv_op_2_0= '^' )
            	    // InternalGaml.g:5347:7: lv_op_2_0= '^'
            	    {
            	    lv_op_2_0=(Token)match(input,132,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(lv_op_2_0, grammarAccess.getExponentiationAccess().getOpCircumflexAccentKeyword_1_0_1_0());
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getExponentiationRule());
            	      							}
            	      							setWithLastConsumed(current, "op", lv_op_2_0, "^");
            	      						
            	    }

            	    }


            	    }


            	    }

            	    // InternalGaml.g:5360:4: ( (lv_right_3_0= ruleBinary ) )
            	    // InternalGaml.g:5361:5: (lv_right_3_0= ruleBinary )
            	    {
            	    // InternalGaml.g:5361:5: (lv_right_3_0= ruleBinary )
            	    // InternalGaml.g:5362:6: lv_right_3_0= ruleBinary
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getExponentiationAccess().getRightBinaryParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_49);
            	    lv_right_3_0=ruleBinary();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getExponentiationRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"gama.core.lang.Gaml.Binary");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExponentiation"


    // $ANTLR start "entryRuleBinary"
    // InternalGaml.g:5384:1: entryRuleBinary returns [EObject current=null] : iv_ruleBinary= ruleBinary EOF ;
    public final EObject entryRuleBinary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinary = null;


        try {
            // InternalGaml.g:5384:47: (iv_ruleBinary= ruleBinary EOF )
            // InternalGaml.g:5385:2: iv_ruleBinary= ruleBinary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBinary=ruleBinary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinary; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinary"


    // $ANTLR start "ruleBinary"
    // InternalGaml.g:5391:1: ruleBinary returns [EObject current=null] : (this_Unit_0= ruleUnit ( ( () ( (lv_op_2_0= ruleValid_ID ) ) ) ( (lv_right_3_0= ruleUnit ) ) )* ) ;
    public final EObject ruleBinary() throws RecognitionException {
        EObject current = null;

        EObject this_Unit_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:5397:2: ( (this_Unit_0= ruleUnit ( ( () ( (lv_op_2_0= ruleValid_ID ) ) ) ( (lv_right_3_0= ruleUnit ) ) )* ) )
            // InternalGaml.g:5398:2: (this_Unit_0= ruleUnit ( ( () ( (lv_op_2_0= ruleValid_ID ) ) ) ( (lv_right_3_0= ruleUnit ) ) )* )
            {
            // InternalGaml.g:5398:2: (this_Unit_0= ruleUnit ( ( () ( (lv_op_2_0= ruleValid_ID ) ) ) ( (lv_right_3_0= ruleUnit ) ) )* )
            // InternalGaml.g:5399:3: this_Unit_0= ruleUnit ( ( () ( (lv_op_2_0= ruleValid_ID ) ) ) ( (lv_right_3_0= ruleUnit ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBinaryAccess().getUnitParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_50);
            this_Unit_0=ruleUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Unit_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalGaml.g:5407:3: ( ( () ( (lv_op_2_0= ruleValid_ID ) ) ) ( (lv_right_3_0= ruleUnit ) ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==RULE_ID) ) {
                    int LA92_2 = input.LA(2);

                    if ( ((LA92_2>=RULE_ID && LA92_2<=RULE_KEYWORD)||LA92_2==31||LA92_2==34||LA92_2==38||(LA92_2>=40 && LA92_2<=87)||LA92_2==129||(LA92_2>=133 && LA92_2<=138)) ) {
                        alt92=1;
                    }


                }
                else if ( (LA92_0==38||(LA92_0>=40 && LA92_0<=87)) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalGaml.g:5408:4: ( () ( (lv_op_2_0= ruleValid_ID ) ) ) ( (lv_right_3_0= ruleUnit ) )
            	    {
            	    // InternalGaml.g:5408:4: ( () ( (lv_op_2_0= ruleValid_ID ) ) )
            	    // InternalGaml.g:5409:5: () ( (lv_op_2_0= ruleValid_ID ) )
            	    {
            	    // InternalGaml.g:5409:5: ()
            	    // InternalGaml.g:5410:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getBinaryAccess().getBinaryOperatorLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalGaml.g:5416:5: ( (lv_op_2_0= ruleValid_ID ) )
            	    // InternalGaml.g:5417:6: (lv_op_2_0= ruleValid_ID )
            	    {
            	    // InternalGaml.g:5417:6: (lv_op_2_0= ruleValid_ID )
            	    // InternalGaml.g:5418:7: lv_op_2_0= ruleValid_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getBinaryAccess().getOpValid_IDParserRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_5);
            	    lv_op_2_0=ruleValid_ID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getBinaryRule());
            	      							}
            	      							set(
            	      								current,
            	      								"op",
            	      								lv_op_2_0,
            	      								"gama.core.lang.Gaml.Valid_ID");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }

            	    // InternalGaml.g:5436:4: ( (lv_right_3_0= ruleUnit ) )
            	    // InternalGaml.g:5437:5: (lv_right_3_0= ruleUnit )
            	    {
            	    // InternalGaml.g:5437:5: (lv_right_3_0= ruleUnit )
            	    // InternalGaml.g:5438:6: lv_right_3_0= ruleUnit
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBinaryAccess().getRightUnitParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_50);
            	    lv_right_3_0=ruleUnit();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBinaryRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"gama.core.lang.Gaml.Unit");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinary"


    // $ANTLR start "entryRuleUnit"
    // InternalGaml.g:5460:1: entryRuleUnit returns [EObject current=null] : iv_ruleUnit= ruleUnit EOF ;
    public final EObject entryRuleUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnit = null;


        try {
            // InternalGaml.g:5460:45: (iv_ruleUnit= ruleUnit EOF )
            // InternalGaml.g:5461:2: iv_ruleUnit= ruleUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnit=ruleUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnit; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnit"


    // $ANTLR start "ruleUnit"
    // InternalGaml.g:5467:1: ruleUnit returns [EObject current=null] : (this_Unary_0= ruleUnary ( ( () ( (lv_op_2_0= '#' ) ) ) ( (lv_right_3_0= ruleUnitRef ) ) )? ) ;
    public final EObject ruleUnit() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_Unary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:5473:2: ( (this_Unary_0= ruleUnary ( ( () ( (lv_op_2_0= '#' ) ) ) ( (lv_right_3_0= ruleUnitRef ) ) )? ) )
            // InternalGaml.g:5474:2: (this_Unary_0= ruleUnary ( ( () ( (lv_op_2_0= '#' ) ) ) ( (lv_right_3_0= ruleUnitRef ) ) )? )
            {
            // InternalGaml.g:5474:2: (this_Unary_0= ruleUnary ( ( () ( (lv_op_2_0= '#' ) ) ) ( (lv_right_3_0= ruleUnitRef ) ) )? )
            // InternalGaml.g:5475:3: this_Unary_0= ruleUnary ( ( () ( (lv_op_2_0= '#' ) ) ) ( (lv_right_3_0= ruleUnitRef ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getUnitAccess().getUnaryParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_51);
            this_Unary_0=ruleUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Unary_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalGaml.g:5483:3: ( ( () ( (lv_op_2_0= '#' ) ) ) ( (lv_right_3_0= ruleUnitRef ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==133) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalGaml.g:5484:4: ( () ( (lv_op_2_0= '#' ) ) ) ( (lv_right_3_0= ruleUnitRef ) )
                    {
                    // InternalGaml.g:5484:4: ( () ( (lv_op_2_0= '#' ) ) )
                    // InternalGaml.g:5485:5: () ( (lv_op_2_0= '#' ) )
                    {
                    // InternalGaml.g:5485:5: ()
                    // InternalGaml.g:5486:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndSet(
                      							grammarAccess.getUnitAccess().getUnitLeftAction_1_0_0(),
                      							current);
                      					
                    }

                    }

                    // InternalGaml.g:5492:5: ( (lv_op_2_0= '#' ) )
                    // InternalGaml.g:5493:6: (lv_op_2_0= '#' )
                    {
                    // InternalGaml.g:5493:6: (lv_op_2_0= '#' )
                    // InternalGaml.g:5494:7: lv_op_2_0= '#'
                    {
                    lv_op_2_0=(Token)match(input,133,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_op_2_0, grammarAccess.getUnitAccess().getOpNumberSignKeyword_1_0_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getUnitRule());
                      							}
                      							setWithLastConsumed(current, "op", lv_op_2_0, "#");
                      						
                    }

                    }


                    }


                    }

                    // InternalGaml.g:5507:4: ( (lv_right_3_0= ruleUnitRef ) )
                    // InternalGaml.g:5508:5: (lv_right_3_0= ruleUnitRef )
                    {
                    // InternalGaml.g:5508:5: (lv_right_3_0= ruleUnitRef )
                    // InternalGaml.g:5509:6: lv_right_3_0= ruleUnitRef
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnitAccess().getRightUnitRefParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleUnitRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnitRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"gama.core.lang.Gaml.UnitRef");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnit"


    // $ANTLR start "entryRuleUnary"
    // InternalGaml.g:5531:1: entryRuleUnary returns [EObject current=null] : iv_ruleUnary= ruleUnary EOF ;
    public final EObject entryRuleUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnary = null;


        try {
            // InternalGaml.g:5531:46: (iv_ruleUnary= ruleUnary EOF )
            // InternalGaml.g:5532:2: iv_ruleUnary= ruleUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnary=ruleUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnary; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnary"


    // $ANTLR start "ruleUnary"
    // InternalGaml.g:5538:1: ruleUnary returns [EObject current=null] : (this_Access_0= ruleAccess | ( () ( ( ( (lv_op_2_0= '#' ) ) ( (lv_right_3_0= ruleUnitRef ) ) ) | ( ( ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) ) ) ;
    public final EObject ruleUnary() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_4_1=null;
        Token lv_op_4_2=null;
        Token lv_op_4_3=null;
        Token lv_op_4_4=null;
        Token lv_op_4_5=null;
        EObject this_Access_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:5544:2: ( (this_Access_0= ruleAccess | ( () ( ( ( (lv_op_2_0= '#' ) ) ( (lv_right_3_0= ruleUnitRef ) ) ) | ( ( ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) ) ) )
            // InternalGaml.g:5545:2: (this_Access_0= ruleAccess | ( () ( ( ( (lv_op_2_0= '#' ) ) ( (lv_right_3_0= ruleUnitRef ) ) ) | ( ( ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) ) )
            {
            // InternalGaml.g:5545:2: (this_Access_0= ruleAccess | ( () ( ( ( (lv_op_2_0= '#' ) ) ( (lv_right_3_0= ruleUnitRef ) ) ) | ( ( ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) ) )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( ((LA96_0>=RULE_ID && LA96_0<=RULE_KEYWORD)||LA96_0==31||LA96_0==34||LA96_0==38||(LA96_0>=40 && LA96_0<=87)||LA96_0==138) ) {
                alt96=1;
            }
            else if ( (LA96_0==129||(LA96_0>=133 && LA96_0<=137)) ) {
                alt96=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // InternalGaml.g:5546:3: this_Access_0= ruleAccess
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryAccess().getAccessParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Access_0=ruleAccess();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Access_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:5555:3: ( () ( ( ( (lv_op_2_0= '#' ) ) ( (lv_right_3_0= ruleUnitRef ) ) ) | ( ( ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) )
                    {
                    // InternalGaml.g:5555:3: ( () ( ( ( (lv_op_2_0= '#' ) ) ( (lv_right_3_0= ruleUnitRef ) ) ) | ( ( ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) )
                    // InternalGaml.g:5556:4: () ( ( ( (lv_op_2_0= '#' ) ) ( (lv_right_3_0= ruleUnitRef ) ) ) | ( ( ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) )
                    {
                    // InternalGaml.g:5556:4: ()
                    // InternalGaml.g:5557:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getUnaryAccess().getUnaryAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalGaml.g:5563:4: ( ( ( (lv_op_2_0= '#' ) ) ( (lv_right_3_0= ruleUnitRef ) ) ) | ( ( ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) )
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==133) ) {
                        alt95=1;
                    }
                    else if ( (LA95_0==129||(LA95_0>=134 && LA95_0<=137)) ) {
                        alt95=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 95, 0, input);

                        throw nvae;
                    }
                    switch (alt95) {
                        case 1 :
                            // InternalGaml.g:5564:5: ( ( (lv_op_2_0= '#' ) ) ( (lv_right_3_0= ruleUnitRef ) ) )
                            {
                            // InternalGaml.g:5564:5: ( ( (lv_op_2_0= '#' ) ) ( (lv_right_3_0= ruleUnitRef ) ) )
                            // InternalGaml.g:5565:6: ( (lv_op_2_0= '#' ) ) ( (lv_right_3_0= ruleUnitRef ) )
                            {
                            // InternalGaml.g:5565:6: ( (lv_op_2_0= '#' ) )
                            // InternalGaml.g:5566:7: (lv_op_2_0= '#' )
                            {
                            // InternalGaml.g:5566:7: (lv_op_2_0= '#' )
                            // InternalGaml.g:5567:8: lv_op_2_0= '#'
                            {
                            lv_op_2_0=(Token)match(input,133,FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_op_2_0, grammarAccess.getUnaryAccess().getOpNumberSignKeyword_1_1_0_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getUnaryRule());
                              								}
                              								setWithLastConsumed(current, "op", lv_op_2_0, "#");
                              							
                            }

                            }


                            }

                            // InternalGaml.g:5579:6: ( (lv_right_3_0= ruleUnitRef ) )
                            // InternalGaml.g:5580:7: (lv_right_3_0= ruleUnitRef )
                            {
                            // InternalGaml.g:5580:7: (lv_right_3_0= ruleUnitRef )
                            // InternalGaml.g:5581:8: lv_right_3_0= ruleUnitRef
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getUnaryAccess().getRightUnitRefParserRuleCall_1_1_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_2);
                            lv_right_3_0=ruleUnitRef();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getUnaryRule());
                              								}
                              								set(
                              									current,
                              									"right",
                              									lv_right_3_0,
                              									"gama.core.lang.Gaml.UnitRef");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalGaml.g:5600:5: ( ( ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) ) ) ( (lv_right_5_0= ruleUnary ) ) )
                            {
                            // InternalGaml.g:5600:5: ( ( ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) ) ) ( (lv_right_5_0= ruleUnary ) ) )
                            // InternalGaml.g:5601:6: ( ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) ) ) ( (lv_right_5_0= ruleUnary ) )
                            {
                            // InternalGaml.g:5601:6: ( ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) ) )
                            // InternalGaml.g:5602:7: ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) )
                            {
                            // InternalGaml.g:5602:7: ( (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' ) )
                            // InternalGaml.g:5603:8: (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' )
                            {
                            // InternalGaml.g:5603:8: (lv_op_4_1= '-' | lv_op_4_2= '!' | lv_op_4_3= 'my' | lv_op_4_4= 'the' | lv_op_4_5= 'not' )
                            int alt94=5;
                            switch ( input.LA(1) ) {
                            case 129:
                                {
                                alt94=1;
                                }
                                break;
                            case 134:
                                {
                                alt94=2;
                                }
                                break;
                            case 135:
                                {
                                alt94=3;
                                }
                                break;
                            case 136:
                                {
                                alt94=4;
                                }
                                break;
                            case 137:
                                {
                                alt94=5;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 94, 0, input);

                                throw nvae;
                            }

                            switch (alt94) {
                                case 1 :
                                    // InternalGaml.g:5604:9: lv_op_4_1= '-'
                                    {
                                    lv_op_4_1=(Token)match(input,129,FOLLOW_5); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									newLeafNode(lv_op_4_1, grammarAccess.getUnaryAccess().getOpHyphenMinusKeyword_1_1_1_0_0_0());
                                      								
                                    }
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElement(grammarAccess.getUnaryRule());
                                      									}
                                      									setWithLastConsumed(current, "op", lv_op_4_1, null);
                                      								
                                    }

                                    }
                                    break;
                                case 2 :
                                    // InternalGaml.g:5615:9: lv_op_4_2= '!'
                                    {
                                    lv_op_4_2=(Token)match(input,134,FOLLOW_5); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									newLeafNode(lv_op_4_2, grammarAccess.getUnaryAccess().getOpExclamationMarkKeyword_1_1_1_0_0_1());
                                      								
                                    }
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElement(grammarAccess.getUnaryRule());
                                      									}
                                      									setWithLastConsumed(current, "op", lv_op_4_2, null);
                                      								
                                    }

                                    }
                                    break;
                                case 3 :
                                    // InternalGaml.g:5626:9: lv_op_4_3= 'my'
                                    {
                                    lv_op_4_3=(Token)match(input,135,FOLLOW_5); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									newLeafNode(lv_op_4_3, grammarAccess.getUnaryAccess().getOpMyKeyword_1_1_1_0_0_2());
                                      								
                                    }
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElement(grammarAccess.getUnaryRule());
                                      									}
                                      									setWithLastConsumed(current, "op", lv_op_4_3, null);
                                      								
                                    }

                                    }
                                    break;
                                case 4 :
                                    // InternalGaml.g:5637:9: lv_op_4_4= 'the'
                                    {
                                    lv_op_4_4=(Token)match(input,136,FOLLOW_5); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									newLeafNode(lv_op_4_4, grammarAccess.getUnaryAccess().getOpTheKeyword_1_1_1_0_0_3());
                                      								
                                    }
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElement(grammarAccess.getUnaryRule());
                                      									}
                                      									setWithLastConsumed(current, "op", lv_op_4_4, null);
                                      								
                                    }

                                    }
                                    break;
                                case 5 :
                                    // InternalGaml.g:5648:9: lv_op_4_5= 'not'
                                    {
                                    lv_op_4_5=(Token)match(input,137,FOLLOW_5); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									newLeafNode(lv_op_4_5, grammarAccess.getUnaryAccess().getOpNotKeyword_1_1_1_0_0_4());
                                      								
                                    }
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElement(grammarAccess.getUnaryRule());
                                      									}
                                      									setWithLastConsumed(current, "op", lv_op_4_5, null);
                                      								
                                    }

                                    }
                                    break;

                            }


                            }


                            }

                            // InternalGaml.g:5661:6: ( (lv_right_5_0= ruleUnary ) )
                            // InternalGaml.g:5662:7: (lv_right_5_0= ruleUnary )
                            {
                            // InternalGaml.g:5662:7: (lv_right_5_0= ruleUnary )
                            // InternalGaml.g:5663:8: lv_right_5_0= ruleUnary
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getUnaryAccess().getRightUnaryParserRuleCall_1_1_1_1_0());
                              							
                            }
                            pushFollow(FOLLOW_2);
                            lv_right_5_0=ruleUnary();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getUnaryRule());
                              								}
                              								set(
                              									current,
                              									"right",
                              									lv_right_5_0,
                              									"gama.core.lang.Gaml.Unary");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnary"


    // $ANTLR start "entryRuleAccess"
    // InternalGaml.g:5687:1: entryRuleAccess returns [EObject current=null] : iv_ruleAccess= ruleAccess EOF ;
    public final EObject entryRuleAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccess = null;


        try {
            // InternalGaml.g:5687:47: (iv_ruleAccess= ruleAccess EOF )
            // InternalGaml.g:5688:2: iv_ruleAccess= ruleAccess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccessRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAccess=ruleAccess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccess; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccess"


    // $ANTLR start "ruleAccess"
    // InternalGaml.g:5694:1: ruleAccess returns [EObject current=null] : (this_Primary_0= rulePrimary ( () ( ( ( (lv_op_2_0= '[' ) ) ( (lv_right_3_0= ruleExpressionList ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '.' ) ) ( ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) ) ) ) ) )* ) ;
    public final EObject ruleAccess() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token otherlv_4=null;
        Token lv_op_5_0=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_1 = null;

        EObject lv_right_6_2 = null;



        	enterRule();

        try {
            // InternalGaml.g:5700:2: ( (this_Primary_0= rulePrimary ( () ( ( ( (lv_op_2_0= '[' ) ) ( (lv_right_3_0= ruleExpressionList ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '.' ) ) ( ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) ) ) ) ) )* ) )
            // InternalGaml.g:5701:2: (this_Primary_0= rulePrimary ( () ( ( ( (lv_op_2_0= '[' ) ) ( (lv_right_3_0= ruleExpressionList ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '.' ) ) ( ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) ) ) ) ) )* )
            {
            // InternalGaml.g:5701:2: (this_Primary_0= rulePrimary ( () ( ( ( (lv_op_2_0= '[' ) ) ( (lv_right_3_0= ruleExpressionList ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '.' ) ) ( ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) ) ) ) ) )* )
            // InternalGaml.g:5702:3: this_Primary_0= rulePrimary ( () ( ( ( (lv_op_2_0= '[' ) ) ( (lv_right_3_0= ruleExpressionList ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '.' ) ) ( ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) ) ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAccessAccess().getPrimaryParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_52);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Primary_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalGaml.g:5710:3: ( () ( ( ( (lv_op_2_0= '[' ) ) ( (lv_right_3_0= ruleExpressionList ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '.' ) ) ( ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) ) ) ) ) )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==138||LA100_0==140) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // InternalGaml.g:5711:4: () ( ( ( (lv_op_2_0= '[' ) ) ( (lv_right_3_0= ruleExpressionList ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '.' ) ) ( ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) ) ) ) )
            	    {
            	    // InternalGaml.g:5711:4: ()
            	    // InternalGaml.g:5712:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAccessAccess().getAccessLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalGaml.g:5718:4: ( ( ( (lv_op_2_0= '[' ) ) ( (lv_right_3_0= ruleExpressionList ) )? otherlv_4= ']' ) | ( ( (lv_op_5_0= '.' ) ) ( ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) ) ) ) )
            	    int alt99=2;
            	    int LA99_0 = input.LA(1);

            	    if ( (LA99_0==138) ) {
            	        alt99=1;
            	    }
            	    else if ( (LA99_0==140) ) {
            	        alt99=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 99, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt99) {
            	        case 1 :
            	            // InternalGaml.g:5719:5: ( ( (lv_op_2_0= '[' ) ) ( (lv_right_3_0= ruleExpressionList ) )? otherlv_4= ']' )
            	            {
            	            // InternalGaml.g:5719:5: ( ( (lv_op_2_0= '[' ) ) ( (lv_right_3_0= ruleExpressionList ) )? otherlv_4= ']' )
            	            // InternalGaml.g:5720:6: ( (lv_op_2_0= '[' ) ) ( (lv_right_3_0= ruleExpressionList ) )? otherlv_4= ']'
            	            {
            	            // InternalGaml.g:5720:6: ( (lv_op_2_0= '[' ) )
            	            // InternalGaml.g:5721:7: (lv_op_2_0= '[' )
            	            {
            	            // InternalGaml.g:5721:7: (lv_op_2_0= '[' )
            	            // InternalGaml.g:5722:8: lv_op_2_0= '['
            	            {
            	            lv_op_2_0=(Token)match(input,138,FOLLOW_53); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_0, grammarAccess.getAccessAccess().getOpLeftSquareBracketKeyword_1_1_0_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getAccessRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_0, "[");
            	              							
            	            }

            	            }


            	            }

            	            // InternalGaml.g:5734:6: ( (lv_right_3_0= ruleExpressionList ) )?
            	            int alt97=2;
            	            int LA97_0 = input.LA(1);

            	            if ( ((LA97_0>=RULE_ID && LA97_0<=RULE_KEYWORD)||LA97_0==29||LA97_0==31||LA97_0==34||LA97_0==38||(LA97_0>=40 && LA97_0<=87)||(LA97_0>=95 && LA97_0<=118)||LA97_0==129||(LA97_0>=133 && LA97_0<=138)) ) {
            	                alt97=1;
            	            }
            	            switch (alt97) {
            	                case 1 :
            	                    // InternalGaml.g:5735:7: (lv_right_3_0= ruleExpressionList )
            	                    {
            	                    // InternalGaml.g:5735:7: (lv_right_3_0= ruleExpressionList )
            	                    // InternalGaml.g:5736:8: lv_right_3_0= ruleExpressionList
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      								newCompositeNode(grammarAccess.getAccessAccess().getRightExpressionListParserRuleCall_1_1_0_1_0());
            	                      							
            	                    }
            	                    pushFollow(FOLLOW_54);
            	                    lv_right_3_0=ruleExpressionList();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      								if (current==null) {
            	                      									current = createModelElementForParent(grammarAccess.getAccessRule());
            	                      								}
            	                      								set(
            	                      									current,
            	                      									"right",
            	                      									lv_right_3_0,
            	                      									"gama.core.lang.Gaml.ExpressionList");
            	                      								afterParserOrEnumRuleCall();
            	                      							
            	                    }

            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_4=(Token)match(input,139,FOLLOW_52); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_4, grammarAccess.getAccessAccess().getRightSquareBracketKeyword_1_1_0_2());
            	              					
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalGaml.g:5759:5: ( ( (lv_op_5_0= '.' ) ) ( ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) ) ) )
            	            {
            	            // InternalGaml.g:5759:5: ( ( (lv_op_5_0= '.' ) ) ( ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) ) ) )
            	            // InternalGaml.g:5760:6: ( (lv_op_5_0= '.' ) ) ( ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) ) )
            	            {
            	            // InternalGaml.g:5760:6: ( (lv_op_5_0= '.' ) )
            	            // InternalGaml.g:5761:7: (lv_op_5_0= '.' )
            	            {
            	            // InternalGaml.g:5761:7: (lv_op_5_0= '.' )
            	            // InternalGaml.g:5762:8: lv_op_5_0= '.'
            	            {
            	            lv_op_5_0=(Token)match(input,140,FOLLOW_13); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_5_0, grammarAccess.getAccessAccess().getOpFullStopKeyword_1_1_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getAccessRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_5_0, ".");
            	              							
            	            }

            	            }


            	            }

            	            // InternalGaml.g:5774:6: ( ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) ) )
            	            // InternalGaml.g:5775:7: ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) )
            	            {
            	            // InternalGaml.g:5775:7: ( (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral ) )
            	            // InternalGaml.g:5776:8: (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral )
            	            {
            	            // InternalGaml.g:5776:8: (lv_right_6_1= ruleAbstractRef | lv_right_6_2= ruleStringLiteral )
            	            int alt98=2;
            	            int LA98_0 = input.LA(1);

            	            if ( (LA98_0==RULE_ID||LA98_0==38||(LA98_0>=40 && LA98_0<=87)) ) {
            	                alt98=1;
            	            }
            	            else if ( (LA98_0==RULE_STRING) ) {
            	                alt98=2;
            	            }
            	            else {
            	                if (state.backtracking>0) {state.failed=true; return current;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 98, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt98) {
            	                case 1 :
            	                    // InternalGaml.g:5777:9: lv_right_6_1= ruleAbstractRef
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      									newCompositeNode(grammarAccess.getAccessAccess().getRightAbstractRefParserRuleCall_1_1_1_1_0_0());
            	                      								
            	                    }
            	                    pushFollow(FOLLOW_52);
            	                    lv_right_6_1=ruleAbstractRef();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      									if (current==null) {
            	                      										current = createModelElementForParent(grammarAccess.getAccessRule());
            	                      									}
            	                      									set(
            	                      										current,
            	                      										"right",
            	                      										lv_right_6_1,
            	                      										"gama.core.lang.Gaml.AbstractRef");
            	                      									afterParserOrEnumRuleCall();
            	                      								
            	                    }

            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalGaml.g:5793:9: lv_right_6_2= ruleStringLiteral
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      									newCompositeNode(grammarAccess.getAccessAccess().getRightStringLiteralParserRuleCall_1_1_1_1_0_1());
            	                      								
            	                    }
            	                    pushFollow(FOLLOW_52);
            	                    lv_right_6_2=ruleStringLiteral();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      									if (current==null) {
            	                      										current = createModelElementForParent(grammarAccess.getAccessRule());
            	                      									}
            	                      									set(
            	                      										current,
            	                      										"right",
            	                      										lv_right_6_2,
            	                      										"gama.core.lang.Gaml.StringLiteral");
            	                      									afterParserOrEnumRuleCall();
            	                      								
            	                    }

            	                    }
            	                    break;

            	            }


            	            }


            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop100;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAccess"


    // $ANTLR start "entryRulePrimary"
    // InternalGaml.g:5818:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalGaml.g:5818:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalGaml.g:5819:2: iv_rulePrimary= rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimary; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalGaml.g:5825:1: rulePrimary returns [EObject current=null] : (this_TerminalExpression_0= ruleTerminalExpression | this_AbstractRef_1= ruleAbstractRef | (otherlv_2= '(' this_ExpressionList_3= ruleExpressionList otherlv_4= ')' ) | (otherlv_5= '[' () ( (lv_exprs_7_0= ruleExpressionList ) )? otherlv_8= ']' ) | (otherlv_9= '{' () ( (lv_left_11_0= ruleExpression ) ) ( (lv_op_12_0= ',' ) ) ( (lv_right_13_0= ruleExpression ) ) (otherlv_14= ',' ( (lv_z_15_0= ruleExpression ) ) )? otherlv_16= '}' ) ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_op_12_0=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject this_TerminalExpression_0 = null;

        EObject this_AbstractRef_1 = null;

        EObject this_ExpressionList_3 = null;

        EObject lv_exprs_7_0 = null;

        EObject lv_left_11_0 = null;

        EObject lv_right_13_0 = null;

        EObject lv_z_15_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:5831:2: ( (this_TerminalExpression_0= ruleTerminalExpression | this_AbstractRef_1= ruleAbstractRef | (otherlv_2= '(' this_ExpressionList_3= ruleExpressionList otherlv_4= ')' ) | (otherlv_5= '[' () ( (lv_exprs_7_0= ruleExpressionList ) )? otherlv_8= ']' ) | (otherlv_9= '{' () ( (lv_left_11_0= ruleExpression ) ) ( (lv_op_12_0= ',' ) ) ( (lv_right_13_0= ruleExpression ) ) (otherlv_14= ',' ( (lv_z_15_0= ruleExpression ) ) )? otherlv_16= '}' ) ) )
            // InternalGaml.g:5832:2: (this_TerminalExpression_0= ruleTerminalExpression | this_AbstractRef_1= ruleAbstractRef | (otherlv_2= '(' this_ExpressionList_3= ruleExpressionList otherlv_4= ')' ) | (otherlv_5= '[' () ( (lv_exprs_7_0= ruleExpressionList ) )? otherlv_8= ']' ) | (otherlv_9= '{' () ( (lv_left_11_0= ruleExpression ) ) ( (lv_op_12_0= ',' ) ) ( (lv_right_13_0= ruleExpression ) ) (otherlv_14= ',' ( (lv_z_15_0= ruleExpression ) ) )? otherlv_16= '}' ) )
            {
            // InternalGaml.g:5832:2: (this_TerminalExpression_0= ruleTerminalExpression | this_AbstractRef_1= ruleAbstractRef | (otherlv_2= '(' this_ExpressionList_3= ruleExpressionList otherlv_4= ')' ) | (otherlv_5= '[' () ( (lv_exprs_7_0= ruleExpressionList ) )? otherlv_8= ']' ) | (otherlv_9= '{' () ( (lv_left_11_0= ruleExpression ) ) ( (lv_op_12_0= ',' ) ) ( (lv_right_13_0= ruleExpression ) ) (otherlv_14= ',' ( (lv_z_15_0= ruleExpression ) ) )? otherlv_16= '}' ) )
            int alt103=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INTEGER:
            case RULE_DOUBLE:
            case RULE_BOOLEAN:
            case RULE_KEYWORD:
                {
                alt103=1;
                }
                break;
            case RULE_ID:
            case 38:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
                {
                alt103=2;
                }
                break;
            case 31:
                {
                alt103=3;
                }
                break;
            case 138:
                {
                alt103=4;
                }
                break;
            case 34:
                {
                alt103=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // InternalGaml.g:5833:3: this_TerminalExpression_0= ruleTerminalExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryAccess().getTerminalExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TerminalExpression_0=ruleTerminalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TerminalExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:5842:3: this_AbstractRef_1= ruleAbstractRef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryAccess().getAbstractRefParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AbstractRef_1=ruleAbstractRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AbstractRef_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGaml.g:5851:3: (otherlv_2= '(' this_ExpressionList_3= ruleExpressionList otherlv_4= ')' )
                    {
                    // InternalGaml.g:5851:3: (otherlv_2= '(' this_ExpressionList_3= ruleExpressionList otherlv_4= ')' )
                    // InternalGaml.g:5852:4: otherlv_2= '(' this_ExpressionList_3= ruleExpressionList otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryAccess().getExpressionListParserRuleCall_2_1());
                      			
                    }
                    pushFollow(FOLLOW_27);
                    this_ExpressionList_3=ruleExpressionList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ExpressionList_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_4=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_2_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalGaml.g:5870:3: (otherlv_5= '[' () ( (lv_exprs_7_0= ruleExpressionList ) )? otherlv_8= ']' )
                    {
                    // InternalGaml.g:5870:3: (otherlv_5= '[' () ( (lv_exprs_7_0= ruleExpressionList ) )? otherlv_8= ']' )
                    // InternalGaml.g:5871:4: otherlv_5= '[' () ( (lv_exprs_7_0= ruleExpressionList ) )? otherlv_8= ']'
                    {
                    otherlv_5=(Token)match(input,138,FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getPrimaryAccess().getLeftSquareBracketKeyword_3_0());
                      			
                    }
                    // InternalGaml.g:5875:4: ()
                    // InternalGaml.g:5876:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getArrayAction_3_1(),
                      						current);
                      				
                    }

                    }

                    // InternalGaml.g:5882:4: ( (lv_exprs_7_0= ruleExpressionList ) )?
                    int alt101=2;
                    int LA101_0 = input.LA(1);

                    if ( ((LA101_0>=RULE_ID && LA101_0<=RULE_KEYWORD)||LA101_0==29||LA101_0==31||LA101_0==34||LA101_0==38||(LA101_0>=40 && LA101_0<=87)||(LA101_0>=95 && LA101_0<=118)||LA101_0==129||(LA101_0>=133 && LA101_0<=138)) ) {
                        alt101=1;
                    }
                    switch (alt101) {
                        case 1 :
                            // InternalGaml.g:5883:5: (lv_exprs_7_0= ruleExpressionList )
                            {
                            // InternalGaml.g:5883:5: (lv_exprs_7_0= ruleExpressionList )
                            // InternalGaml.g:5884:6: lv_exprs_7_0= ruleExpressionList
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getPrimaryAccess().getExprsExpressionListParserRuleCall_3_2_0());
                              					
                            }
                            pushFollow(FOLLOW_54);
                            lv_exprs_7_0=ruleExpressionList();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getPrimaryRule());
                              						}
                              						set(
                              							current,
                              							"exprs",
                              							lv_exprs_7_0,
                              							"gama.core.lang.Gaml.ExpressionList");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,139,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getPrimaryAccess().getRightSquareBracketKeyword_3_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalGaml.g:5907:3: (otherlv_9= '{' () ( (lv_left_11_0= ruleExpression ) ) ( (lv_op_12_0= ',' ) ) ( (lv_right_13_0= ruleExpression ) ) (otherlv_14= ',' ( (lv_z_15_0= ruleExpression ) ) )? otherlv_16= '}' )
                    {
                    // InternalGaml.g:5907:3: (otherlv_9= '{' () ( (lv_left_11_0= ruleExpression ) ) ( (lv_op_12_0= ',' ) ) ( (lv_right_13_0= ruleExpression ) ) (otherlv_14= ',' ( (lv_z_15_0= ruleExpression ) ) )? otherlv_16= '}' )
                    // InternalGaml.g:5908:4: otherlv_9= '{' () ( (lv_left_11_0= ruleExpression ) ) ( (lv_op_12_0= ',' ) ) ( (lv_right_13_0= ruleExpression ) ) (otherlv_14= ',' ( (lv_z_15_0= ruleExpression ) ) )? otherlv_16= '}'
                    {
                    otherlv_9=(Token)match(input,34,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPrimaryAccess().getLeftCurlyBracketKeyword_4_0());
                      			
                    }
                    // InternalGaml.g:5912:4: ()
                    // InternalGaml.g:5913:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getPointAction_4_1(),
                      						current);
                      				
                    }

                    }

                    // InternalGaml.g:5919:4: ( (lv_left_11_0= ruleExpression ) )
                    // InternalGaml.g:5920:5: (lv_left_11_0= ruleExpression )
                    {
                    // InternalGaml.g:5920:5: (lv_left_11_0= ruleExpression )
                    // InternalGaml.g:5921:6: lv_left_11_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryAccess().getLeftExpressionParserRuleCall_4_2_0());
                      					
                    }
                    pushFollow(FOLLOW_55);
                    lv_left_11_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      						}
                      						set(
                      							current,
                      							"left",
                      							lv_left_11_0,
                      							"gama.core.lang.Gaml.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalGaml.g:5938:4: ( (lv_op_12_0= ',' ) )
                    // InternalGaml.g:5939:5: (lv_op_12_0= ',' )
                    {
                    // InternalGaml.g:5939:5: (lv_op_12_0= ',' )
                    // InternalGaml.g:5940:6: lv_op_12_0= ','
                    {
                    lv_op_12_0=(Token)match(input,94,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_12_0, grammarAccess.getPrimaryAccess().getOpCommaKeyword_4_3_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrimaryRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_12_0, ",");
                      					
                    }

                    }


                    }

                    // InternalGaml.g:5952:4: ( (lv_right_13_0= ruleExpression ) )
                    // InternalGaml.g:5953:5: (lv_right_13_0= ruleExpression )
                    {
                    // InternalGaml.g:5953:5: (lv_right_13_0= ruleExpression )
                    // InternalGaml.g:5954:6: lv_right_13_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryAccess().getRightExpressionParserRuleCall_4_4_0());
                      					
                    }
                    pushFollow(FOLLOW_56);
                    lv_right_13_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_13_0,
                      							"gama.core.lang.Gaml.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalGaml.g:5971:4: (otherlv_14= ',' ( (lv_z_15_0= ruleExpression ) ) )?
                    int alt102=2;
                    int LA102_0 = input.LA(1);

                    if ( (LA102_0==94) ) {
                        alt102=1;
                    }
                    switch (alt102) {
                        case 1 :
                            // InternalGaml.g:5972:5: otherlv_14= ',' ( (lv_z_15_0= ruleExpression ) )
                            {
                            otherlv_14=(Token)match(input,94,FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_14, grammarAccess.getPrimaryAccess().getCommaKeyword_4_5_0());
                              				
                            }
                            // InternalGaml.g:5976:5: ( (lv_z_15_0= ruleExpression ) )
                            // InternalGaml.g:5977:6: (lv_z_15_0= ruleExpression )
                            {
                            // InternalGaml.g:5977:6: (lv_z_15_0= ruleExpression )
                            // InternalGaml.g:5978:7: lv_z_15_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getPrimaryAccess().getZExpressionParserRuleCall_4_5_1_0());
                              						
                            }
                            pushFollow(FOLLOW_37);
                            lv_z_15_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getPrimaryRule());
                              							}
                              							set(
                              								current,
                              								"z",
                              								lv_z_15_0,
                              								"gama.core.lang.Gaml.Expression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_16=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getPrimaryAccess().getRightCurlyBracketKeyword_4_6());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleAbstractRef"
    // InternalGaml.g:6005:1: entryRuleAbstractRef returns [EObject current=null] : iv_ruleAbstractRef= ruleAbstractRef EOF ;
    public final EObject entryRuleAbstractRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRef = null;


        try {
            // InternalGaml.g:6005:52: (iv_ruleAbstractRef= ruleAbstractRef EOF )
            // InternalGaml.g:6006:2: iv_ruleAbstractRef= ruleAbstractRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbstractRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAbstractRef=ruleAbstractRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbstractRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractRef"


    // $ANTLR start "ruleAbstractRef"
    // InternalGaml.g:6012:1: ruleAbstractRef returns [EObject current=null] : ( ( ( ruleFunction )=>this_Function_0= ruleFunction ) | this_VariableRef_1= ruleVariableRef ) ;
    public final EObject ruleAbstractRef() throws RecognitionException {
        EObject current = null;

        EObject this_Function_0 = null;

        EObject this_VariableRef_1 = null;



        	enterRule();

        try {
            // InternalGaml.g:6018:2: ( ( ( ( ruleFunction )=>this_Function_0= ruleFunction ) | this_VariableRef_1= ruleVariableRef ) )
            // InternalGaml.g:6019:2: ( ( ( ruleFunction )=>this_Function_0= ruleFunction ) | this_VariableRef_1= ruleVariableRef )
            {
            // InternalGaml.g:6019:2: ( ( ( ruleFunction )=>this_Function_0= ruleFunction ) | this_VariableRef_1= ruleVariableRef )
            int alt104=2;
            alt104 = dfa104.predict(input);
            switch (alt104) {
                case 1 :
                    // InternalGaml.g:6020:3: ( ( ruleFunction )=>this_Function_0= ruleFunction )
                    {
                    // InternalGaml.g:6020:3: ( ( ruleFunction )=>this_Function_0= ruleFunction )
                    // InternalGaml.g:6021:4: ( ruleFunction )=>this_Function_0= ruleFunction
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAbstractRefAccess().getFunctionParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_Function_0=ruleFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Function_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:6032:3: this_VariableRef_1= ruleVariableRef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractRefAccess().getVariableRefParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableRef_1=ruleVariableRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableRef_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractRef"


    // $ANTLR start "entryRuleFunction"
    // InternalGaml.g:6044:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalGaml.g:6044:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalGaml.g:6045:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalGaml.g:6051:1: ruleFunction returns [EObject current=null] : ( () ( (lv_left_1_0= ruleActionRef ) ) ( (lv_type_2_0= ruleTypeInfo ) )? otherlv_3= '(' ( (lv_right_4_0= ruleExpressionList ) )? otherlv_5= ')' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_left_1_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:6057:2: ( ( () ( (lv_left_1_0= ruleActionRef ) ) ( (lv_type_2_0= ruleTypeInfo ) )? otherlv_3= '(' ( (lv_right_4_0= ruleExpressionList ) )? otherlv_5= ')' ) )
            // InternalGaml.g:6058:2: ( () ( (lv_left_1_0= ruleActionRef ) ) ( (lv_type_2_0= ruleTypeInfo ) )? otherlv_3= '(' ( (lv_right_4_0= ruleExpressionList ) )? otherlv_5= ')' )
            {
            // InternalGaml.g:6058:2: ( () ( (lv_left_1_0= ruleActionRef ) ) ( (lv_type_2_0= ruleTypeInfo ) )? otherlv_3= '(' ( (lv_right_4_0= ruleExpressionList ) )? otherlv_5= ')' )
            // InternalGaml.g:6059:3: () ( (lv_left_1_0= ruleActionRef ) ) ( (lv_type_2_0= ruleTypeInfo ) )? otherlv_3= '(' ( (lv_right_4_0= ruleExpressionList ) )? otherlv_5= ')'
            {
            // InternalGaml.g:6059:3: ()
            // InternalGaml.g:6060:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFunctionAccess().getFunctionAction_0(),
              					current);
              			
            }

            }

            // InternalGaml.g:6066:3: ( (lv_left_1_0= ruleActionRef ) )
            // InternalGaml.g:6067:4: (lv_left_1_0= ruleActionRef )
            {
            // InternalGaml.g:6067:4: (lv_left_1_0= ruleActionRef )
            // InternalGaml.g:6068:5: lv_left_1_0= ruleActionRef
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionAccess().getLeftActionRefParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_57);
            lv_left_1_0=ruleActionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionRule());
              					}
              					set(
              						current,
              						"left",
              						lv_left_1_0,
              						"gama.core.lang.Gaml.ActionRef");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:6085:3: ( (lv_type_2_0= ruleTypeInfo ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==127) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalGaml.g:6086:4: (lv_type_2_0= ruleTypeInfo )
                    {
                    // InternalGaml.g:6086:4: (lv_type_2_0= ruleTypeInfo )
                    // InternalGaml.g:6087:5: lv_type_2_0= ruleTypeInfo
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionAccess().getTypeTypeInfoParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_58);
                    lv_type_2_0=ruleTypeInfo();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFunctionRule());
                      					}
                      					set(
                      						current,
                      						"type",
                      						lv_type_2_0,
                      						"gama.core.lang.Gaml.TypeInfo");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,31,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_3());
              		
            }
            // InternalGaml.g:6108:3: ( (lv_right_4_0= ruleExpressionList ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( ((LA106_0>=RULE_ID && LA106_0<=RULE_KEYWORD)||LA106_0==29||LA106_0==31||LA106_0==34||LA106_0==38||(LA106_0>=40 && LA106_0<=87)||(LA106_0>=95 && LA106_0<=118)||LA106_0==129||(LA106_0>=133 && LA106_0<=138)) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalGaml.g:6109:4: (lv_right_4_0= ruleExpressionList )
                    {
                    // InternalGaml.g:6109:4: (lv_right_4_0= ruleExpressionList )
                    // InternalGaml.g:6110:5: lv_right_4_0= ruleExpressionList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionAccess().getRightExpressionListParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_27);
                    lv_right_4_0=ruleExpressionList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFunctionRule());
                      					}
                      					set(
                      						current,
                      						"right",
                      						lv_right_4_0,
                      						"gama.core.lang.Gaml.ExpressionList");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleExpressionList"
    // InternalGaml.g:6135:1: entryRuleExpressionList returns [EObject current=null] : iv_ruleExpressionList= ruleExpressionList EOF ;
    public final EObject entryRuleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionList = null;


        try {
            // InternalGaml.g:6135:55: (iv_ruleExpressionList= ruleExpressionList EOF )
            // InternalGaml.g:6136:2: iv_ruleExpressionList= ruleExpressionList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionList=ruleExpressionList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionList"


    // $ANTLR start "ruleExpressionList"
    // InternalGaml.g:6142:1: ruleExpressionList returns [EObject current=null] : ( ( (lv_exprs_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_exprs_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleExpressionList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_exprs_0_0 = null;

        EObject lv_exprs_2_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:6148:2: ( ( ( (lv_exprs_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_exprs_2_0= ruleExpression ) ) )* ) )
            // InternalGaml.g:6149:2: ( ( (lv_exprs_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_exprs_2_0= ruleExpression ) ) )* )
            {
            // InternalGaml.g:6149:2: ( ( (lv_exprs_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_exprs_2_0= ruleExpression ) ) )* )
            // InternalGaml.g:6150:3: ( (lv_exprs_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_exprs_2_0= ruleExpression ) ) )*
            {
            // InternalGaml.g:6150:3: ( (lv_exprs_0_0= ruleExpression ) )
            // InternalGaml.g:6151:4: (lv_exprs_0_0= ruleExpression )
            {
            // InternalGaml.g:6151:4: (lv_exprs_0_0= ruleExpression )
            // InternalGaml.g:6152:5: lv_exprs_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExpressionListAccess().getExprsExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_35);
            lv_exprs_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExpressionListRule());
              					}
              					add(
              						current,
              						"exprs",
              						lv_exprs_0_0,
              						"gama.core.lang.Gaml.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:6169:3: (otherlv_1= ',' ( (lv_exprs_2_0= ruleExpression ) ) )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==94) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // InternalGaml.g:6170:4: otherlv_1= ',' ( (lv_exprs_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,94,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getExpressionListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalGaml.g:6174:4: ( (lv_exprs_2_0= ruleExpression ) )
            	    // InternalGaml.g:6175:5: (lv_exprs_2_0= ruleExpression )
            	    {
            	    // InternalGaml.g:6175:5: (lv_exprs_2_0= ruleExpression )
            	    // InternalGaml.g:6176:6: lv_exprs_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getExpressionListAccess().getExprsExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_exprs_2_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getExpressionListRule());
            	      						}
            	      						add(
            	      							current,
            	      							"exprs",
            	      							lv_exprs_2_0,
            	      							"gama.core.lang.Gaml.Expression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionList"


    // $ANTLR start "entryRuleUnitRef"
    // InternalGaml.g:6198:1: entryRuleUnitRef returns [EObject current=null] : iv_ruleUnitRef= ruleUnitRef EOF ;
    public final EObject entryRuleUnitRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitRef = null;


        try {
            // InternalGaml.g:6198:48: (iv_ruleUnitRef= ruleUnitRef EOF )
            // InternalGaml.g:6199:2: iv_ruleUnitRef= ruleUnitRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnitRef=ruleUnitRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnitRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnitRef"


    // $ANTLR start "ruleUnitRef"
    // InternalGaml.g:6205:1: ruleUnitRef returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleUnitRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGaml.g:6211:2: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // InternalGaml.g:6212:2: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalGaml.g:6212:2: ( () ( (otherlv_1= RULE_ID ) ) )
            // InternalGaml.g:6213:3: () ( (otherlv_1= RULE_ID ) )
            {
            // InternalGaml.g:6213:3: ()
            // InternalGaml.g:6214:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUnitRefAccess().getUnitNameAction_0(),
              					current);
              			
            }

            }

            // InternalGaml.g:6220:3: ( (otherlv_1= RULE_ID ) )
            // InternalGaml.g:6221:4: (otherlv_1= RULE_ID )
            {
            // InternalGaml.g:6221:4: (otherlv_1= RULE_ID )
            // InternalGaml.g:6222:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getUnitRefRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getUnitRefAccess().getRefUnitFakeDefinitionCrossReference_1_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnitRef"


    // $ANTLR start "entryRuleVariableRef"
    // InternalGaml.g:6237:1: entryRuleVariableRef returns [EObject current=null] : iv_ruleVariableRef= ruleVariableRef EOF ;
    public final EObject entryRuleVariableRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableRef = null;


        try {
            // InternalGaml.g:6237:52: (iv_ruleVariableRef= ruleVariableRef EOF )
            // InternalGaml.g:6238:2: iv_ruleVariableRef= ruleVariableRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableRef=ruleVariableRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableRef"


    // $ANTLR start "ruleVariableRef"
    // InternalGaml.g:6244:1: ruleVariableRef returns [EObject current=null] : ( () ( ( ruleValid_ID ) ) ) ;
    public final EObject ruleVariableRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalGaml.g:6250:2: ( ( () ( ( ruleValid_ID ) ) ) )
            // InternalGaml.g:6251:2: ( () ( ( ruleValid_ID ) ) )
            {
            // InternalGaml.g:6251:2: ( () ( ( ruleValid_ID ) ) )
            // InternalGaml.g:6252:3: () ( ( ruleValid_ID ) )
            {
            // InternalGaml.g:6252:3: ()
            // InternalGaml.g:6253:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVariableRefAccess().getVariableRefAction_0(),
              					current);
              			
            }

            }

            // InternalGaml.g:6259:3: ( ( ruleValid_ID ) )
            // InternalGaml.g:6260:4: ( ruleValid_ID )
            {
            // InternalGaml.g:6260:4: ( ruleValid_ID )
            // InternalGaml.g:6261:5: ruleValid_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableRefRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVariableRefAccess().getRefVarDefinitionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleValid_ID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableRef"


    // $ANTLR start "entryRuleTypeRef"
    // InternalGaml.g:6279:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // InternalGaml.g:6279:48: (iv_ruleTypeRef= ruleTypeRef EOF )
            // InternalGaml.g:6280:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalGaml.g:6286:1: ruleTypeRef returns [EObject current=null] : ( ( () ( ( (otherlv_1= RULE_ID ) ) ( (lv_parameter_2_0= ruleTypeInfo ) )? ) ) | ( () (otherlv_4= 'species' ( (lv_parameter_5_0= ruleTypeInfo ) ) ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_parameter_2_0 = null;

        EObject lv_parameter_5_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:6292:2: ( ( ( () ( ( (otherlv_1= RULE_ID ) ) ( (lv_parameter_2_0= ruleTypeInfo ) )? ) ) | ( () (otherlv_4= 'species' ( (lv_parameter_5_0= ruleTypeInfo ) ) ) ) ) )
            // InternalGaml.g:6293:2: ( ( () ( ( (otherlv_1= RULE_ID ) ) ( (lv_parameter_2_0= ruleTypeInfo ) )? ) ) | ( () (otherlv_4= 'species' ( (lv_parameter_5_0= ruleTypeInfo ) ) ) ) )
            {
            // InternalGaml.g:6293:2: ( ( () ( ( (otherlv_1= RULE_ID ) ) ( (lv_parameter_2_0= ruleTypeInfo ) )? ) ) | ( () (otherlv_4= 'species' ( (lv_parameter_5_0= ruleTypeInfo ) ) ) ) )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==RULE_ID) ) {
                alt109=1;
            }
            else if ( (LA109_0==40) ) {
                alt109=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }
            switch (alt109) {
                case 1 :
                    // InternalGaml.g:6294:3: ( () ( ( (otherlv_1= RULE_ID ) ) ( (lv_parameter_2_0= ruleTypeInfo ) )? ) )
                    {
                    // InternalGaml.g:6294:3: ( () ( ( (otherlv_1= RULE_ID ) ) ( (lv_parameter_2_0= ruleTypeInfo ) )? ) )
                    // InternalGaml.g:6295:4: () ( ( (otherlv_1= RULE_ID ) ) ( (lv_parameter_2_0= ruleTypeInfo ) )? )
                    {
                    // InternalGaml.g:6295:4: ()
                    // InternalGaml.g:6296:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getTypeRefAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalGaml.g:6302:4: ( ( (otherlv_1= RULE_ID ) ) ( (lv_parameter_2_0= ruleTypeInfo ) )? )
                    // InternalGaml.g:6303:5: ( (otherlv_1= RULE_ID ) ) ( (lv_parameter_2_0= ruleTypeInfo ) )?
                    {
                    // InternalGaml.g:6303:5: ( (otherlv_1= RULE_ID ) )
                    // InternalGaml.g:6304:6: (otherlv_1= RULE_ID )
                    {
                    // InternalGaml.g:6304:6: (otherlv_1= RULE_ID )
                    // InternalGaml.g:6305:7: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getTypeRefRule());
                      							}
                      						
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_60); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_1, grammarAccess.getTypeRefAccess().getRefTypeDefinitionCrossReference_0_1_0_0());
                      						
                    }

                    }


                    }

                    // InternalGaml.g:6316:5: ( (lv_parameter_2_0= ruleTypeInfo ) )?
                    int alt108=2;
                    int LA108_0 = input.LA(1);

                    if ( (LA108_0==127) ) {
                        alt108=1;
                    }
                    switch (alt108) {
                        case 1 :
                            // InternalGaml.g:6317:6: (lv_parameter_2_0= ruleTypeInfo )
                            {
                            // InternalGaml.g:6317:6: (lv_parameter_2_0= ruleTypeInfo )
                            // InternalGaml.g:6318:7: lv_parameter_2_0= ruleTypeInfo
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getTypeRefAccess().getParameterTypeInfoParserRuleCall_0_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_parameter_2_0=ruleTypeInfo();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getTypeRefRule());
                              							}
                              							set(
                              								current,
                              								"parameter",
                              								lv_parameter_2_0,
                              								"gama.core.lang.Gaml.TypeInfo");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:6338:3: ( () (otherlv_4= 'species' ( (lv_parameter_5_0= ruleTypeInfo ) ) ) )
                    {
                    // InternalGaml.g:6338:3: ( () (otherlv_4= 'species' ( (lv_parameter_5_0= ruleTypeInfo ) ) ) )
                    // InternalGaml.g:6339:4: () (otherlv_4= 'species' ( (lv_parameter_5_0= ruleTypeInfo ) ) )
                    {
                    // InternalGaml.g:6339:4: ()
                    // InternalGaml.g:6340:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getTypeRefAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalGaml.g:6346:4: (otherlv_4= 'species' ( (lv_parameter_5_0= ruleTypeInfo ) ) )
                    // InternalGaml.g:6347:5: otherlv_4= 'species' ( (lv_parameter_5_0= ruleTypeInfo ) )
                    {
                    otherlv_4=(Token)match(input,40,FOLLOW_61); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getTypeRefAccess().getSpeciesKeyword_1_1_0());
                      				
                    }
                    // InternalGaml.g:6351:5: ( (lv_parameter_5_0= ruleTypeInfo ) )
                    // InternalGaml.g:6352:6: (lv_parameter_5_0= ruleTypeInfo )
                    {
                    // InternalGaml.g:6352:6: (lv_parameter_5_0= ruleTypeInfo )
                    // InternalGaml.g:6353:7: lv_parameter_5_0= ruleTypeInfo
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getTypeRefAccess().getParameterTypeInfoParserRuleCall_1_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_parameter_5_0=ruleTypeInfo();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getTypeRefRule());
                      							}
                      							set(
                      								current,
                      								"parameter",
                      								lv_parameter_5_0,
                      								"gama.core.lang.Gaml.TypeInfo");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleTypeInfo"
    // InternalGaml.g:6376:1: entryRuleTypeInfo returns [EObject current=null] : iv_ruleTypeInfo= ruleTypeInfo EOF ;
    public final EObject entryRuleTypeInfo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeInfo = null;


        try {
            // InternalGaml.g:6376:49: (iv_ruleTypeInfo= ruleTypeInfo EOF )
            // InternalGaml.g:6377:2: iv_ruleTypeInfo= ruleTypeInfo EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeInfoRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeInfo=ruleTypeInfo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeInfo; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeInfo"


    // $ANTLR start "ruleTypeInfo"
    // InternalGaml.g:6383:1: ruleTypeInfo returns [EObject current=null] : (otherlv_0= '<' ( (lv_first_1_0= ruleTypeRef ) ) (otherlv_2= ',' ( (lv_second_3_0= ruleTypeRef ) ) )? ( ( '>' )=>otherlv_4= '>' ) ) ;
    public final EObject ruleTypeInfo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_first_1_0 = null;

        EObject lv_second_3_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:6389:2: ( (otherlv_0= '<' ( (lv_first_1_0= ruleTypeRef ) ) (otherlv_2= ',' ( (lv_second_3_0= ruleTypeRef ) ) )? ( ( '>' )=>otherlv_4= '>' ) ) )
            // InternalGaml.g:6390:2: (otherlv_0= '<' ( (lv_first_1_0= ruleTypeRef ) ) (otherlv_2= ',' ( (lv_second_3_0= ruleTypeRef ) ) )? ( ( '>' )=>otherlv_4= '>' ) )
            {
            // InternalGaml.g:6390:2: (otherlv_0= '<' ( (lv_first_1_0= ruleTypeRef ) ) (otherlv_2= ',' ( (lv_second_3_0= ruleTypeRef ) ) )? ( ( '>' )=>otherlv_4= '>' ) )
            // InternalGaml.g:6391:3: otherlv_0= '<' ( (lv_first_1_0= ruleTypeRef ) ) (otherlv_2= ',' ( (lv_second_3_0= ruleTypeRef ) ) )? ( ( '>' )=>otherlv_4= '>' )
            {
            otherlv_0=(Token)match(input,127,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeInfoAccess().getLessThanSignKeyword_0());
              		
            }
            // InternalGaml.g:6395:3: ( (lv_first_1_0= ruleTypeRef ) )
            // InternalGaml.g:6396:4: (lv_first_1_0= ruleTypeRef )
            {
            // InternalGaml.g:6396:4: (lv_first_1_0= ruleTypeRef )
            // InternalGaml.g:6397:5: lv_first_1_0= ruleTypeRef
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeInfoAccess().getFirstTypeRefParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_62);
            lv_first_1_0=ruleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypeInfoRule());
              					}
              					set(
              						current,
              						"first",
              						lv_first_1_0,
              						"gama.core.lang.Gaml.TypeRef");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalGaml.g:6414:3: (otherlv_2= ',' ( (lv_second_3_0= ruleTypeRef ) ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==94) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalGaml.g:6415:4: otherlv_2= ',' ( (lv_second_3_0= ruleTypeRef ) )
                    {
                    otherlv_2=(Token)match(input,94,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getTypeInfoAccess().getCommaKeyword_2_0());
                      			
                    }
                    // InternalGaml.g:6419:4: ( (lv_second_3_0= ruleTypeRef ) )
                    // InternalGaml.g:6420:5: (lv_second_3_0= ruleTypeRef )
                    {
                    // InternalGaml.g:6420:5: (lv_second_3_0= ruleTypeRef )
                    // InternalGaml.g:6421:6: lv_second_3_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeInfoAccess().getSecondTypeRefParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_33);
                    lv_second_3_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTypeInfoRule());
                      						}
                      						set(
                      							current,
                      							"second",
                      							lv_second_3_0,
                      							"gama.core.lang.Gaml.TypeRef");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalGaml.g:6439:3: ( ( '>' )=>otherlv_4= '>' )
            // InternalGaml.g:6440:4: ( '>' )=>otherlv_4= '>'
            {
            otherlv_4=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_4, grammarAccess.getTypeInfoAccess().getGreaterThanSignKeyword_3());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeInfo"


    // $ANTLR start "entryRuleActionRef"
    // InternalGaml.g:6450:1: entryRuleActionRef returns [EObject current=null] : iv_ruleActionRef= ruleActionRef EOF ;
    public final EObject entryRuleActionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionRef = null;


        try {
            // InternalGaml.g:6450:50: (iv_ruleActionRef= ruleActionRef EOF )
            // InternalGaml.g:6451:2: iv_ruleActionRef= ruleActionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActionRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleActionRef=ruleActionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActionRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionRef"


    // $ANTLR start "ruleActionRef"
    // InternalGaml.g:6457:1: ruleActionRef returns [EObject current=null] : ( () ( ( ruleValid_ID ) ) ) ;
    public final EObject ruleActionRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalGaml.g:6463:2: ( ( () ( ( ruleValid_ID ) ) ) )
            // InternalGaml.g:6464:2: ( () ( ( ruleValid_ID ) ) )
            {
            // InternalGaml.g:6464:2: ( () ( ( ruleValid_ID ) ) )
            // InternalGaml.g:6465:3: () ( ( ruleValid_ID ) )
            {
            // InternalGaml.g:6465:3: ()
            // InternalGaml.g:6466:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getActionRefAccess().getActionRefAction_0(),
              					current);
              			
            }

            }

            // InternalGaml.g:6472:3: ( ( ruleValid_ID ) )
            // InternalGaml.g:6473:4: ( ruleValid_ID )
            {
            // InternalGaml.g:6473:4: ( ruleValid_ID )
            // InternalGaml.g:6474:5: ruleValid_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getActionRefRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getActionRefAccess().getRefActionDefinitionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleValid_ID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionRef"


    // $ANTLR start "entryRuleEquationRef"
    // InternalGaml.g:6492:1: entryRuleEquationRef returns [EObject current=null] : iv_ruleEquationRef= ruleEquationRef EOF ;
    public final EObject entryRuleEquationRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquationRef = null;


        try {
            // InternalGaml.g:6492:52: (iv_ruleEquationRef= ruleEquationRef EOF )
            // InternalGaml.g:6493:2: iv_ruleEquationRef= ruleEquationRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEquationRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEquationRef=ruleEquationRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEquationRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquationRef"


    // $ANTLR start "ruleEquationRef"
    // InternalGaml.g:6499:1: ruleEquationRef returns [EObject current=null] : ( () ( ( ruleValid_ID ) ) ) ;
    public final EObject ruleEquationRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalGaml.g:6505:2: ( ( () ( ( ruleValid_ID ) ) ) )
            // InternalGaml.g:6506:2: ( () ( ( ruleValid_ID ) ) )
            {
            // InternalGaml.g:6506:2: ( () ( ( ruleValid_ID ) ) )
            // InternalGaml.g:6507:3: () ( ( ruleValid_ID ) )
            {
            // InternalGaml.g:6507:3: ()
            // InternalGaml.g:6508:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getEquationRefAccess().getEquationRefAction_0(),
              					current);
              			
            }

            }

            // InternalGaml.g:6514:3: ( ( ruleValid_ID ) )
            // InternalGaml.g:6515:4: ( ruleValid_ID )
            {
            // InternalGaml.g:6515:4: ( ruleValid_ID )
            // InternalGaml.g:6516:5: ruleValid_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEquationRefRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEquationRefAccess().getRefEquationDefinitionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleValid_ID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquationRef"


    // $ANTLR start "entryRuleEquationDefinition"
    // InternalGaml.g:6534:1: entryRuleEquationDefinition returns [EObject current=null] : iv_ruleEquationDefinition= ruleEquationDefinition EOF ;
    public final EObject entryRuleEquationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquationDefinition = null;


        try {
            // InternalGaml.g:6534:59: (iv_ruleEquationDefinition= ruleEquationDefinition EOF )
            // InternalGaml.g:6535:2: iv_ruleEquationDefinition= ruleEquationDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEquationDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEquationDefinition=ruleEquationDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEquationDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquationDefinition"


    // $ANTLR start "ruleEquationDefinition"
    // InternalGaml.g:6541:1: ruleEquationDefinition returns [EObject current=null] : (this_S_Equations_0= ruleS_Equations | this_EquationFakeDefinition_1= ruleEquationFakeDefinition ) ;
    public final EObject ruleEquationDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_S_Equations_0 = null;

        EObject this_EquationFakeDefinition_1 = null;



        	enterRule();

        try {
            // InternalGaml.g:6547:2: ( (this_S_Equations_0= ruleS_Equations | this_EquationFakeDefinition_1= ruleEquationFakeDefinition ) )
            // InternalGaml.g:6548:2: (this_S_Equations_0= ruleS_Equations | this_EquationFakeDefinition_1= ruleEquationFakeDefinition )
            {
            // InternalGaml.g:6548:2: (this_S_Equations_0= ruleS_Equations | this_EquationFakeDefinition_1= ruleEquationFakeDefinition )
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==38) ) {
                alt111=1;
            }
            else if ( (LA111_0==146) ) {
                alt111=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }
            switch (alt111) {
                case 1 :
                    // InternalGaml.g:6549:3: this_S_Equations_0= ruleS_Equations
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEquationDefinitionAccess().getS_EquationsParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Equations_0=ruleS_Equations();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_S_Equations_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:6558:3: this_EquationFakeDefinition_1= ruleEquationFakeDefinition
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEquationDefinitionAccess().getEquationFakeDefinitionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EquationFakeDefinition_1=ruleEquationFakeDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EquationFakeDefinition_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquationDefinition"


    // $ANTLR start "entryRuleTypeDefinition"
    // InternalGaml.g:6570:1: entryRuleTypeDefinition returns [EObject current=null] : iv_ruleTypeDefinition= ruleTypeDefinition EOF ;
    public final EObject entryRuleTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinition = null;


        try {
            // InternalGaml.g:6570:55: (iv_ruleTypeDefinition= ruleTypeDefinition EOF )
            // InternalGaml.g:6571:2: iv_ruleTypeDefinition= ruleTypeDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeDefinition=ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeDefinition"


    // $ANTLR start "ruleTypeDefinition"
    // InternalGaml.g:6577:1: ruleTypeDefinition returns [EObject current=null] : (this_S_Species_0= ruleS_Species | this_TypeFakeDefinition_1= ruleTypeFakeDefinition ) ;
    public final EObject ruleTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_S_Species_0 = null;

        EObject this_TypeFakeDefinition_1 = null;



        	enterRule();

        try {
            // InternalGaml.g:6583:2: ( (this_S_Species_0= ruleS_Species | this_TypeFakeDefinition_1= ruleTypeFakeDefinition ) )
            // InternalGaml.g:6584:2: (this_S_Species_0= ruleS_Species | this_TypeFakeDefinition_1= ruleTypeFakeDefinition )
            {
            // InternalGaml.g:6584:2: (this_S_Species_0= ruleS_Species | this_TypeFakeDefinition_1= ruleTypeFakeDefinition )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( ((LA112_0>=40 && LA112_0<=41)) ) {
                alt112=1;
            }
            else if ( (LA112_0==142) ) {
                alt112=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }
            switch (alt112) {
                case 1 :
                    // InternalGaml.g:6585:3: this_S_Species_0= ruleS_Species
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeDefinitionAccess().getS_SpeciesParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Species_0=ruleS_Species();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_S_Species_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:6594:3: this_TypeFakeDefinition_1= ruleTypeFakeDefinition
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeDefinitionAccess().getTypeFakeDefinitionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeFakeDefinition_1=ruleTypeFakeDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeFakeDefinition_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeDefinition"


    // $ANTLR start "entryRuleVarDefinition"
    // InternalGaml.g:6606:1: entryRuleVarDefinition returns [EObject current=null] : iv_ruleVarDefinition= ruleVarDefinition EOF ;
    public final EObject entryRuleVarDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDefinition = null;


        try {
            // InternalGaml.g:6606:54: (iv_ruleVarDefinition= ruleVarDefinition EOF )
            // InternalGaml.g:6607:2: iv_ruleVarDefinition= ruleVarDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVarDefinition=ruleVarDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDefinition"


    // $ANTLR start "ruleVarDefinition"
    // InternalGaml.g:6613:1: ruleVarDefinition returns [EObject current=null] : ( ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration ) | (this_Model_1= ruleModel | this_ArgumentDefinition_2= ruleArgumentDefinition | this_DefinitionFacet_3= ruleDefinitionFacet | this_VarFakeDefinition_4= ruleVarFakeDefinition | this_Import_5= ruleImport | this_S_Experiment_6= ruleS_Experiment ) ) ;
    public final EObject ruleVarDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_S_Declaration_0 = null;

        EObject this_Model_1 = null;

        EObject this_ArgumentDefinition_2 = null;

        EObject this_DefinitionFacet_3 = null;

        EObject this_VarFakeDefinition_4 = null;

        EObject this_Import_5 = null;

        EObject this_S_Experiment_6 = null;



        	enterRule();

        try {
            // InternalGaml.g:6619:2: ( ( ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration ) | (this_Model_1= ruleModel | this_ArgumentDefinition_2= ruleArgumentDefinition | this_DefinitionFacet_3= ruleDefinitionFacet | this_VarFakeDefinition_4= ruleVarFakeDefinition | this_Import_5= ruleImport | this_S_Experiment_6= ruleS_Experiment ) ) )
            // InternalGaml.g:6620:2: ( ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration ) | (this_Model_1= ruleModel | this_ArgumentDefinition_2= ruleArgumentDefinition | this_DefinitionFacet_3= ruleDefinitionFacet | this_VarFakeDefinition_4= ruleVarFakeDefinition | this_Import_5= ruleImport | this_S_Experiment_6= ruleS_Experiment ) )
            {
            // InternalGaml.g:6620:2: ( ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration ) | (this_Model_1= ruleModel | this_ArgumentDefinition_2= ruleArgumentDefinition | this_DefinitionFacet_3= ruleDefinitionFacet | this_VarFakeDefinition_4= ruleVarFakeDefinition | this_Import_5= ruleImport | this_S_Experiment_6= ruleS_Experiment ) )
            int alt114=2;
            alt114 = dfa114.predict(input);
            switch (alt114) {
                case 1 :
                    // InternalGaml.g:6621:3: ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration )
                    {
                    // InternalGaml.g:6621:3: ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration )
                    // InternalGaml.g:6622:4: ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getVarDefinitionAccess().getS_DeclarationParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Declaration_0=ruleS_Declaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_S_Declaration_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalGaml.g:6633:3: (this_Model_1= ruleModel | this_ArgumentDefinition_2= ruleArgumentDefinition | this_DefinitionFacet_3= ruleDefinitionFacet | this_VarFakeDefinition_4= ruleVarFakeDefinition | this_Import_5= ruleImport | this_S_Experiment_6= ruleS_Experiment )
                    {
                    // InternalGaml.g:6633:3: (this_Model_1= ruleModel | this_ArgumentDefinition_2= ruleArgumentDefinition | this_DefinitionFacet_3= ruleDefinitionFacet | this_VarFakeDefinition_4= ruleVarFakeDefinition | this_Import_5= ruleImport | this_S_Experiment_6= ruleS_Experiment )
                    int alt113=6;
                    switch ( input.LA(1) ) {
                    case 16:
                    case 19:
                        {
                        alt113=1;
                        }
                        break;
                    case RULE_ID:
                    case 40:
                        {
                        alt113=2;
                        }
                        break;
                    case 95:
                    case 96:
                        {
                        alt113=3;
                        }
                        break;
                    case 145:
                        {
                        alt113=4;
                        }
                        break;
                    case 17:
                        {
                        alt113=5;
                        }
                        break;
                    case 42:
                        {
                        alt113=6;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 113, 0, input);

                        throw nvae;
                    }

                    switch (alt113) {
                        case 1 :
                            // InternalGaml.g:6634:4: this_Model_1= ruleModel
                            {
                            if ( state.backtracking==0 ) {

                              				newCompositeNode(grammarAccess.getVarDefinitionAccess().getModelParserRuleCall_1_0());
                              			
                            }
                            pushFollow(FOLLOW_2);
                            this_Model_1=ruleModel();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              				current = this_Model_1;
                              				afterParserOrEnumRuleCall();
                              			
                            }

                            }
                            break;
                        case 2 :
                            // InternalGaml.g:6643:4: this_ArgumentDefinition_2= ruleArgumentDefinition
                            {
                            if ( state.backtracking==0 ) {

                              				newCompositeNode(grammarAccess.getVarDefinitionAccess().getArgumentDefinitionParserRuleCall_1_1());
                              			
                            }
                            pushFollow(FOLLOW_2);
                            this_ArgumentDefinition_2=ruleArgumentDefinition();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              				current = this_ArgumentDefinition_2;
                              				afterParserOrEnumRuleCall();
                              			
                            }

                            }
                            break;
                        case 3 :
                            // InternalGaml.g:6652:4: this_DefinitionFacet_3= ruleDefinitionFacet
                            {
                            if ( state.backtracking==0 ) {

                              				newCompositeNode(grammarAccess.getVarDefinitionAccess().getDefinitionFacetParserRuleCall_1_2());
                              			
                            }
                            pushFollow(FOLLOW_2);
                            this_DefinitionFacet_3=ruleDefinitionFacet();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              				current = this_DefinitionFacet_3;
                              				afterParserOrEnumRuleCall();
                              			
                            }

                            }
                            break;
                        case 4 :
                            // InternalGaml.g:6661:4: this_VarFakeDefinition_4= ruleVarFakeDefinition
                            {
                            if ( state.backtracking==0 ) {

                              				newCompositeNode(grammarAccess.getVarDefinitionAccess().getVarFakeDefinitionParserRuleCall_1_3());
                              			
                            }
                            pushFollow(FOLLOW_2);
                            this_VarFakeDefinition_4=ruleVarFakeDefinition();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              				current = this_VarFakeDefinition_4;
                              				afterParserOrEnumRuleCall();
                              			
                            }

                            }
                            break;
                        case 5 :
                            // InternalGaml.g:6670:4: this_Import_5= ruleImport
                            {
                            if ( state.backtracking==0 ) {

                              				newCompositeNode(grammarAccess.getVarDefinitionAccess().getImportParserRuleCall_1_4());
                              			
                            }
                            pushFollow(FOLLOW_2);
                            this_Import_5=ruleImport();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              				current = this_Import_5;
                              				afterParserOrEnumRuleCall();
                              			
                            }

                            }
                            break;
                        case 6 :
                            // InternalGaml.g:6679:4: this_S_Experiment_6= ruleS_Experiment
                            {
                            if ( state.backtracking==0 ) {

                              				newCompositeNode(grammarAccess.getVarDefinitionAccess().getS_ExperimentParserRuleCall_1_5());
                              			
                            }
                            pushFollow(FOLLOW_2);
                            this_S_Experiment_6=ruleS_Experiment();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              				current = this_S_Experiment_6;
                              				afterParserOrEnumRuleCall();
                              			
                            }

                            }
                            break;

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarDefinition"


    // $ANTLR start "entryRuleActionDefinition"
    // InternalGaml.g:6692:1: entryRuleActionDefinition returns [EObject current=null] : iv_ruleActionDefinition= ruleActionDefinition EOF ;
    public final EObject entryRuleActionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionDefinition = null;


        try {
            // InternalGaml.g:6692:57: (iv_ruleActionDefinition= ruleActionDefinition EOF )
            // InternalGaml.g:6693:2: iv_ruleActionDefinition= ruleActionDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActionDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleActionDefinition=ruleActionDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActionDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionDefinition"


    // $ANTLR start "ruleActionDefinition"
    // InternalGaml.g:6699:1: ruleActionDefinition returns [EObject current=null] : (this_S_Action_0= ruleS_Action | this_ActionFakeDefinition_1= ruleActionFakeDefinition | this_S_Definition_2= ruleS_Definition | this_TypeDefinition_3= ruleTypeDefinition ) ;
    public final EObject ruleActionDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_S_Action_0 = null;

        EObject this_ActionFakeDefinition_1 = null;

        EObject this_S_Definition_2 = null;

        EObject this_TypeDefinition_3 = null;



        	enterRule();

        try {
            // InternalGaml.g:6705:2: ( (this_S_Action_0= ruleS_Action | this_ActionFakeDefinition_1= ruleActionFakeDefinition | this_S_Definition_2= ruleS_Definition | this_TypeDefinition_3= ruleTypeDefinition ) )
            // InternalGaml.g:6706:2: (this_S_Action_0= ruleS_Action | this_ActionFakeDefinition_1= ruleActionFakeDefinition | this_S_Definition_2= ruleS_Definition | this_TypeDefinition_3= ruleTypeDefinition )
            {
            // InternalGaml.g:6706:2: (this_S_Action_0= ruleS_Action | this_ActionFakeDefinition_1= ruleActionFakeDefinition | this_S_Definition_2= ruleS_Definition | this_TypeDefinition_3= ruleTypeDefinition )
            int alt115=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt115=1;
                }
                break;
            case 143:
                {
                alt115=2;
                }
                break;
            case RULE_ID:
                {
                alt115=3;
                }
                break;
            case 40:
                {
                int LA115_4 = input.LA(2);

                if ( (LA115_4==RULE_ID) ) {
                    alt115=4;
                }
                else if ( (LA115_4==127) ) {
                    alt115=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 115, 4, input);

                    throw nvae;
                }
                }
                break;
            case 41:
            case 142:
                {
                alt115=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;
            }

            switch (alt115) {
                case 1 :
                    // InternalGaml.g:6707:3: this_S_Action_0= ruleS_Action
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getActionDefinitionAccess().getS_ActionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Action_0=ruleS_Action();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_S_Action_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:6716:3: this_ActionFakeDefinition_1= ruleActionFakeDefinition
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getActionDefinitionAccess().getActionFakeDefinitionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ActionFakeDefinition_1=ruleActionFakeDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ActionFakeDefinition_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGaml.g:6725:3: this_S_Definition_2= ruleS_Definition
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getActionDefinitionAccess().getS_DefinitionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_S_Definition_2=ruleS_Definition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_S_Definition_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalGaml.g:6734:3: this_TypeDefinition_3= ruleTypeDefinition
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getActionDefinitionAccess().getTypeDefinitionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeDefinition_3=ruleTypeDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeDefinition_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionDefinition"


    // $ANTLR start "entryRuleUnitFakeDefinition"
    // InternalGaml.g:6746:1: entryRuleUnitFakeDefinition returns [EObject current=null] : iv_ruleUnitFakeDefinition= ruleUnitFakeDefinition EOF ;
    public final EObject entryRuleUnitFakeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitFakeDefinition = null;


        try {
            // InternalGaml.g:6746:59: (iv_ruleUnitFakeDefinition= ruleUnitFakeDefinition EOF )
            // InternalGaml.g:6747:2: iv_ruleUnitFakeDefinition= ruleUnitFakeDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitFakeDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnitFakeDefinition=ruleUnitFakeDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnitFakeDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnitFakeDefinition"


    // $ANTLR start "ruleUnitFakeDefinition"
    // InternalGaml.g:6753:1: ruleUnitFakeDefinition returns [EObject current=null] : (otherlv_0= '**unit*' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleUnitFakeDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalGaml.g:6759:2: ( (otherlv_0= '**unit*' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalGaml.g:6760:2: (otherlv_0= '**unit*' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalGaml.g:6760:2: (otherlv_0= '**unit*' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalGaml.g:6761:3: otherlv_0= '**unit*' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,141,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getUnitFakeDefinitionAccess().getUnitKeyword_0());
              		
            }
            // InternalGaml.g:6765:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGaml.g:6766:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGaml.g:6766:4: (lv_name_1_0= RULE_ID )
            // InternalGaml.g:6767:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getUnitFakeDefinitionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getUnitFakeDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"gama.core.lang.Gaml.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnitFakeDefinition"


    // $ANTLR start "entryRuleTypeFakeDefinition"
    // InternalGaml.g:6787:1: entryRuleTypeFakeDefinition returns [EObject current=null] : iv_ruleTypeFakeDefinition= ruleTypeFakeDefinition EOF ;
    public final EObject entryRuleTypeFakeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeFakeDefinition = null;


        try {
            // InternalGaml.g:6787:59: (iv_ruleTypeFakeDefinition= ruleTypeFakeDefinition EOF )
            // InternalGaml.g:6788:2: iv_ruleTypeFakeDefinition= ruleTypeFakeDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeFakeDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeFakeDefinition=ruleTypeFakeDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeFakeDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeFakeDefinition"


    // $ANTLR start "ruleTypeFakeDefinition"
    // InternalGaml.g:6794:1: ruleTypeFakeDefinition returns [EObject current=null] : (otherlv_0= '**type*' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleTypeFakeDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalGaml.g:6800:2: ( (otherlv_0= '**type*' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalGaml.g:6801:2: (otherlv_0= '**type*' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalGaml.g:6801:2: (otherlv_0= '**type*' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalGaml.g:6802:3: otherlv_0= '**type*' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,142,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeFakeDefinitionAccess().getTypeKeyword_0());
              		
            }
            // InternalGaml.g:6806:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGaml.g:6807:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGaml.g:6807:4: (lv_name_1_0= RULE_ID )
            // InternalGaml.g:6808:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getTypeFakeDefinitionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTypeFakeDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"gama.core.lang.Gaml.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeFakeDefinition"


    // $ANTLR start "entryRuleActionFakeDefinition"
    // InternalGaml.g:6828:1: entryRuleActionFakeDefinition returns [EObject current=null] : iv_ruleActionFakeDefinition= ruleActionFakeDefinition EOF ;
    public final EObject entryRuleActionFakeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionFakeDefinition = null;


        try {
            // InternalGaml.g:6828:61: (iv_ruleActionFakeDefinition= ruleActionFakeDefinition EOF )
            // InternalGaml.g:6829:2: iv_ruleActionFakeDefinition= ruleActionFakeDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActionFakeDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleActionFakeDefinition=ruleActionFakeDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActionFakeDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionFakeDefinition"


    // $ANTLR start "ruleActionFakeDefinition"
    // InternalGaml.g:6835:1: ruleActionFakeDefinition returns [EObject current=null] : (otherlv_0= '**action*' ( (lv_name_1_0= ruleValid_ID ) ) ) ;
    public final EObject ruleActionFakeDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:6841:2: ( (otherlv_0= '**action*' ( (lv_name_1_0= ruleValid_ID ) ) ) )
            // InternalGaml.g:6842:2: (otherlv_0= '**action*' ( (lv_name_1_0= ruleValid_ID ) ) )
            {
            // InternalGaml.g:6842:2: (otherlv_0= '**action*' ( (lv_name_1_0= ruleValid_ID ) ) )
            // InternalGaml.g:6843:3: otherlv_0= '**action*' ( (lv_name_1_0= ruleValid_ID ) )
            {
            otherlv_0=(Token)match(input,143,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getActionFakeDefinitionAccess().getActionKeyword_0());
              		
            }
            // InternalGaml.g:6847:3: ( (lv_name_1_0= ruleValid_ID ) )
            // InternalGaml.g:6848:4: (lv_name_1_0= ruleValid_ID )
            {
            // InternalGaml.g:6848:4: (lv_name_1_0= ruleValid_ID )
            // InternalGaml.g:6849:5: lv_name_1_0= ruleValid_ID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getActionFakeDefinitionAccess().getNameValid_IDParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValid_ID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getActionFakeDefinitionRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"gama.core.lang.Gaml.Valid_ID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionFakeDefinition"


    // $ANTLR start "entryRuleSkillFakeDefinition"
    // InternalGaml.g:6870:1: entryRuleSkillFakeDefinition returns [EObject current=null] : iv_ruleSkillFakeDefinition= ruleSkillFakeDefinition EOF ;
    public final EObject entryRuleSkillFakeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSkillFakeDefinition = null;


        try {
            // InternalGaml.g:6870:60: (iv_ruleSkillFakeDefinition= ruleSkillFakeDefinition EOF )
            // InternalGaml.g:6871:2: iv_ruleSkillFakeDefinition= ruleSkillFakeDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSkillFakeDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSkillFakeDefinition=ruleSkillFakeDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSkillFakeDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSkillFakeDefinition"


    // $ANTLR start "ruleSkillFakeDefinition"
    // InternalGaml.g:6877:1: ruleSkillFakeDefinition returns [EObject current=null] : (otherlv_0= '**skill*' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSkillFakeDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalGaml.g:6883:2: ( (otherlv_0= '**skill*' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalGaml.g:6884:2: (otherlv_0= '**skill*' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalGaml.g:6884:2: (otherlv_0= '**skill*' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalGaml.g:6885:3: otherlv_0= '**skill*' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,144,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSkillFakeDefinitionAccess().getSkillKeyword_0());
              		
            }
            // InternalGaml.g:6889:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGaml.g:6890:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGaml.g:6890:4: (lv_name_1_0= RULE_ID )
            // InternalGaml.g:6891:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getSkillFakeDefinitionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSkillFakeDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"gama.core.lang.Gaml.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSkillFakeDefinition"


    // $ANTLR start "entryRuleVarFakeDefinition"
    // InternalGaml.g:6911:1: entryRuleVarFakeDefinition returns [EObject current=null] : iv_ruleVarFakeDefinition= ruleVarFakeDefinition EOF ;
    public final EObject entryRuleVarFakeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarFakeDefinition = null;


        try {
            // InternalGaml.g:6911:58: (iv_ruleVarFakeDefinition= ruleVarFakeDefinition EOF )
            // InternalGaml.g:6912:2: iv_ruleVarFakeDefinition= ruleVarFakeDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarFakeDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVarFakeDefinition=ruleVarFakeDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarFakeDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarFakeDefinition"


    // $ANTLR start "ruleVarFakeDefinition"
    // InternalGaml.g:6918:1: ruleVarFakeDefinition returns [EObject current=null] : (otherlv_0= '**var*' ( (lv_name_1_0= ruleValid_ID ) ) ) ;
    public final EObject ruleVarFakeDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:6924:2: ( (otherlv_0= '**var*' ( (lv_name_1_0= ruleValid_ID ) ) ) )
            // InternalGaml.g:6925:2: (otherlv_0= '**var*' ( (lv_name_1_0= ruleValid_ID ) ) )
            {
            // InternalGaml.g:6925:2: (otherlv_0= '**var*' ( (lv_name_1_0= ruleValid_ID ) ) )
            // InternalGaml.g:6926:3: otherlv_0= '**var*' ( (lv_name_1_0= ruleValid_ID ) )
            {
            otherlv_0=(Token)match(input,145,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getVarFakeDefinitionAccess().getVarKeyword_0());
              		
            }
            // InternalGaml.g:6930:3: ( (lv_name_1_0= ruleValid_ID ) )
            // InternalGaml.g:6931:4: (lv_name_1_0= ruleValid_ID )
            {
            // InternalGaml.g:6931:4: (lv_name_1_0= ruleValid_ID )
            // InternalGaml.g:6932:5: lv_name_1_0= ruleValid_ID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVarFakeDefinitionAccess().getNameValid_IDParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValid_ID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVarFakeDefinitionRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"gama.core.lang.Gaml.Valid_ID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarFakeDefinition"


    // $ANTLR start "entryRuleEquationFakeDefinition"
    // InternalGaml.g:6953:1: entryRuleEquationFakeDefinition returns [EObject current=null] : iv_ruleEquationFakeDefinition= ruleEquationFakeDefinition EOF ;
    public final EObject entryRuleEquationFakeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquationFakeDefinition = null;


        try {
            // InternalGaml.g:6953:63: (iv_ruleEquationFakeDefinition= ruleEquationFakeDefinition EOF )
            // InternalGaml.g:6954:2: iv_ruleEquationFakeDefinition= ruleEquationFakeDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEquationFakeDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEquationFakeDefinition=ruleEquationFakeDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEquationFakeDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquationFakeDefinition"


    // $ANTLR start "ruleEquationFakeDefinition"
    // InternalGaml.g:6960:1: ruleEquationFakeDefinition returns [EObject current=null] : (otherlv_0= '**equation*' ( (lv_name_1_0= ruleValid_ID ) ) ) ;
    public final EObject ruleEquationFakeDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:6966:2: ( (otherlv_0= '**equation*' ( (lv_name_1_0= ruleValid_ID ) ) ) )
            // InternalGaml.g:6967:2: (otherlv_0= '**equation*' ( (lv_name_1_0= ruleValid_ID ) ) )
            {
            // InternalGaml.g:6967:2: (otherlv_0= '**equation*' ( (lv_name_1_0= ruleValid_ID ) ) )
            // InternalGaml.g:6968:3: otherlv_0= '**equation*' ( (lv_name_1_0= ruleValid_ID ) )
            {
            otherlv_0=(Token)match(input,146,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEquationFakeDefinitionAccess().getEquationKeyword_0());
              		
            }
            // InternalGaml.g:6972:3: ( (lv_name_1_0= ruleValid_ID ) )
            // InternalGaml.g:6973:4: (lv_name_1_0= ruleValid_ID )
            {
            // InternalGaml.g:6973:4: (lv_name_1_0= ruleValid_ID )
            // InternalGaml.g:6974:5: lv_name_1_0= ruleValid_ID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEquationFakeDefinitionAccess().getNameValid_IDParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValid_ID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEquationFakeDefinitionRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"gama.core.lang.Gaml.Valid_ID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquationFakeDefinition"


    // $ANTLR start "entryRuleValid_ID"
    // InternalGaml.g:6995:1: entryRuleValid_ID returns [String current=null] : iv_ruleValid_ID= ruleValid_ID EOF ;
    public final String entryRuleValid_ID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValid_ID = null;


        try {
            // InternalGaml.g:6995:48: (iv_ruleValid_ID= ruleValid_ID EOF )
            // InternalGaml.g:6996:2: iv_ruleValid_ID= ruleValid_ID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValid_IDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValid_ID=ruleValid_ID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValid_ID.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValid_ID"


    // $ANTLR start "ruleValid_ID"
    // InternalGaml.g:7002:1: ruleValid_ID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this__SpeciesKey_0= rule_SpeciesKey | this__DoKey_1= rule_DoKey | this__ReflexKey_2= rule_ReflexKey | this__1Expr_Facets_BlockOrEnd_Key_3= rule_1Expr_Facets_BlockOrEnd_Key | this__EquationsKey_4= rule_EquationsKey | this_ID_5= RULE_ID | this__ExperimentKey_6= rule_ExperimentKey ) ;
    public final AntlrDatatypeRuleToken ruleValid_ID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_5=null;
        AntlrDatatypeRuleToken this__SpeciesKey_0 = null;

        AntlrDatatypeRuleToken this__DoKey_1 = null;

        AntlrDatatypeRuleToken this__ReflexKey_2 = null;

        AntlrDatatypeRuleToken this__1Expr_Facets_BlockOrEnd_Key_3 = null;

        AntlrDatatypeRuleToken this__EquationsKey_4 = null;

        AntlrDatatypeRuleToken this__ExperimentKey_6 = null;



        	enterRule();

        try {
            // InternalGaml.g:7008:2: ( (this__SpeciesKey_0= rule_SpeciesKey | this__DoKey_1= rule_DoKey | this__ReflexKey_2= rule_ReflexKey | this__1Expr_Facets_BlockOrEnd_Key_3= rule_1Expr_Facets_BlockOrEnd_Key | this__EquationsKey_4= rule_EquationsKey | this_ID_5= RULE_ID | this__ExperimentKey_6= rule_ExperimentKey ) )
            // InternalGaml.g:7009:2: (this__SpeciesKey_0= rule_SpeciesKey | this__DoKey_1= rule_DoKey | this__ReflexKey_2= rule_ReflexKey | this__1Expr_Facets_BlockOrEnd_Key_3= rule_1Expr_Facets_BlockOrEnd_Key | this__EquationsKey_4= rule_EquationsKey | this_ID_5= RULE_ID | this__ExperimentKey_6= rule_ExperimentKey )
            {
            // InternalGaml.g:7009:2: (this__SpeciesKey_0= rule_SpeciesKey | this__DoKey_1= rule_DoKey | this__ReflexKey_2= rule_ReflexKey | this__1Expr_Facets_BlockOrEnd_Key_3= rule_1Expr_Facets_BlockOrEnd_Key | this__EquationsKey_4= rule_EquationsKey | this_ID_5= RULE_ID | this__ExperimentKey_6= rule_ExperimentKey )
            int alt116=7;
            switch ( input.LA(1) ) {
            case 40:
            case 41:
                {
                alt116=1;
                }
                break;
            case 83:
            case 84:
                {
                alt116=2;
                }
                break;
            case 85:
            case 86:
            case 87:
                {
                alt116=3;
                }
                break;
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
                {
                alt116=4;
                }
                break;
            case 38:
                {
                alt116=5;
                }
                break;
            case RULE_ID:
                {
                alt116=6;
                }
                break;
            case 42:
                {
                alt116=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;
            }

            switch (alt116) {
                case 1 :
                    // InternalGaml.g:7010:3: this__SpeciesKey_0= rule_SpeciesKey
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValid_IDAccess().get_SpeciesKeyParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this__SpeciesKey_0=rule_SpeciesKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this__SpeciesKey_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:7021:3: this__DoKey_1= rule_DoKey
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValid_IDAccess().get_DoKeyParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this__DoKey_1=rule_DoKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this__DoKey_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalGaml.g:7032:3: this__ReflexKey_2= rule_ReflexKey
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValid_IDAccess().get_ReflexKeyParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this__ReflexKey_2=rule_ReflexKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this__ReflexKey_2);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalGaml.g:7043:3: this__1Expr_Facets_BlockOrEnd_Key_3= rule_1Expr_Facets_BlockOrEnd_Key
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValid_IDAccess().get_1Expr_Facets_BlockOrEnd_KeyParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this__1Expr_Facets_BlockOrEnd_Key_3=rule_1Expr_Facets_BlockOrEnd_Key();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this__1Expr_Facets_BlockOrEnd_Key_3);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalGaml.g:7054:3: this__EquationsKey_4= rule_EquationsKey
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValid_IDAccess().get_EquationsKeyParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this__EquationsKey_4=rule_EquationsKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this__EquationsKey_4);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalGaml.g:7065:3: this_ID_5= RULE_ID
                    {
                    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_5);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_5, grammarAccess.getValid_IDAccess().getIDTerminalRuleCall_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalGaml.g:7073:3: this__ExperimentKey_6= rule_ExperimentKey
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValid_IDAccess().get_ExperimentKeyParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this__ExperimentKey_6=rule_ExperimentKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this__ExperimentKey_6);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValid_ID"


    // $ANTLR start "entryRuleTerminalExpression"
    // InternalGaml.g:7087:1: entryRuleTerminalExpression returns [EObject current=null] : iv_ruleTerminalExpression= ruleTerminalExpression EOF ;
    public final EObject entryRuleTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpression = null;


        try {
            // InternalGaml.g:7087:59: (iv_ruleTerminalExpression= ruleTerminalExpression EOF )
            // InternalGaml.g:7088:2: iv_ruleTerminalExpression= ruleTerminalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTerminalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTerminalExpression=ruleTerminalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerminalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalExpression"


    // $ANTLR start "ruleTerminalExpression"
    // InternalGaml.g:7094:1: ruleTerminalExpression returns [EObject current=null] : (this_StringLiteral_0= ruleStringLiteral | ( () ( (lv_op_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_op_4_0= RULE_DOUBLE ) ) ) | ( () ( (lv_op_6_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_op_8_0= RULE_KEYWORD ) ) ) ) ;
    public final EObject ruleTerminalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_4_0=null;
        Token lv_op_6_0=null;
        Token lv_op_8_0=null;
        EObject this_StringLiteral_0 = null;



        	enterRule();

        try {
            // InternalGaml.g:7100:2: ( (this_StringLiteral_0= ruleStringLiteral | ( () ( (lv_op_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_op_4_0= RULE_DOUBLE ) ) ) | ( () ( (lv_op_6_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_op_8_0= RULE_KEYWORD ) ) ) ) )
            // InternalGaml.g:7101:2: (this_StringLiteral_0= ruleStringLiteral | ( () ( (lv_op_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_op_4_0= RULE_DOUBLE ) ) ) | ( () ( (lv_op_6_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_op_8_0= RULE_KEYWORD ) ) ) )
            {
            // InternalGaml.g:7101:2: (this_StringLiteral_0= ruleStringLiteral | ( () ( (lv_op_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_op_4_0= RULE_DOUBLE ) ) ) | ( () ( (lv_op_6_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_op_8_0= RULE_KEYWORD ) ) ) )
            int alt117=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt117=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt117=2;
                }
                break;
            case RULE_DOUBLE:
                {
                alt117=3;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt117=4;
                }
                break;
            case RULE_KEYWORD:
                {
                alt117=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }

            switch (alt117) {
                case 1 :
                    // InternalGaml.g:7102:3: this_StringLiteral_0= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTerminalExpressionAccess().getStringLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringLiteral_0=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalGaml.g:7111:3: ( () ( (lv_op_2_0= RULE_INTEGER ) ) )
                    {
                    // InternalGaml.g:7111:3: ( () ( (lv_op_2_0= RULE_INTEGER ) ) )
                    // InternalGaml.g:7112:4: () ( (lv_op_2_0= RULE_INTEGER ) )
                    {
                    // InternalGaml.g:7112:4: ()
                    // InternalGaml.g:7113:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTerminalExpressionAccess().getIntLiteralAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalGaml.g:7119:4: ( (lv_op_2_0= RULE_INTEGER ) )
                    // InternalGaml.g:7120:5: (lv_op_2_0= RULE_INTEGER )
                    {
                    // InternalGaml.g:7120:5: (lv_op_2_0= RULE_INTEGER )
                    // InternalGaml.g:7121:6: lv_op_2_0= RULE_INTEGER
                    {
                    lv_op_2_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_2_0, grammarAccess.getTerminalExpressionAccess().getOpINTEGERTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTerminalExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"op",
                      							lv_op_2_0,
                      							"gama.core.lang.Gaml.INTEGER");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalGaml.g:7139:3: ( () ( (lv_op_4_0= RULE_DOUBLE ) ) )
                    {
                    // InternalGaml.g:7139:3: ( () ( (lv_op_4_0= RULE_DOUBLE ) ) )
                    // InternalGaml.g:7140:4: () ( (lv_op_4_0= RULE_DOUBLE ) )
                    {
                    // InternalGaml.g:7140:4: ()
                    // InternalGaml.g:7141:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTerminalExpressionAccess().getDoubleLiteralAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalGaml.g:7147:4: ( (lv_op_4_0= RULE_DOUBLE ) )
                    // InternalGaml.g:7148:5: (lv_op_4_0= RULE_DOUBLE )
                    {
                    // InternalGaml.g:7148:5: (lv_op_4_0= RULE_DOUBLE )
                    // InternalGaml.g:7149:6: lv_op_4_0= RULE_DOUBLE
                    {
                    lv_op_4_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_4_0, grammarAccess.getTerminalExpressionAccess().getOpDOUBLETerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTerminalExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"op",
                      							lv_op_4_0,
                      							"gama.core.lang.Gaml.DOUBLE");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalGaml.g:7167:3: ( () ( (lv_op_6_0= RULE_BOOLEAN ) ) )
                    {
                    // InternalGaml.g:7167:3: ( () ( (lv_op_6_0= RULE_BOOLEAN ) ) )
                    // InternalGaml.g:7168:4: () ( (lv_op_6_0= RULE_BOOLEAN ) )
                    {
                    // InternalGaml.g:7168:4: ()
                    // InternalGaml.g:7169:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTerminalExpressionAccess().getBooleanLiteralAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalGaml.g:7175:4: ( (lv_op_6_0= RULE_BOOLEAN ) )
                    // InternalGaml.g:7176:5: (lv_op_6_0= RULE_BOOLEAN )
                    {
                    // InternalGaml.g:7176:5: (lv_op_6_0= RULE_BOOLEAN )
                    // InternalGaml.g:7177:6: lv_op_6_0= RULE_BOOLEAN
                    {
                    lv_op_6_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_6_0, grammarAccess.getTerminalExpressionAccess().getOpBOOLEANTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTerminalExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"op",
                      							lv_op_6_0,
                      							"gama.core.lang.Gaml.BOOLEAN");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalGaml.g:7195:3: ( () ( (lv_op_8_0= RULE_KEYWORD ) ) )
                    {
                    // InternalGaml.g:7195:3: ( () ( (lv_op_8_0= RULE_KEYWORD ) ) )
                    // InternalGaml.g:7196:4: () ( (lv_op_8_0= RULE_KEYWORD ) )
                    {
                    // InternalGaml.g:7196:4: ()
                    // InternalGaml.g:7197:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTerminalExpressionAccess().getReservedLiteralAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalGaml.g:7203:4: ( (lv_op_8_0= RULE_KEYWORD ) )
                    // InternalGaml.g:7204:5: (lv_op_8_0= RULE_KEYWORD )
                    {
                    // InternalGaml.g:7204:5: (lv_op_8_0= RULE_KEYWORD )
                    // InternalGaml.g:7205:6: lv_op_8_0= RULE_KEYWORD
                    {
                    lv_op_8_0=(Token)match(input,RULE_KEYWORD,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_8_0, grammarAccess.getTerminalExpressionAccess().getOpKEYWORDTerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTerminalExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"op",
                      							lv_op_8_0,
                      							"gama.core.lang.Gaml.KEYWORD");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalExpression"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalGaml.g:7226:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalGaml.g:7226:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalGaml.g:7227:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalGaml.g:7233:1: ruleStringLiteral returns [EObject current=null] : ( (lv_op_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_0=null;


        	enterRule();

        try {
            // InternalGaml.g:7239:2: ( ( (lv_op_0_0= RULE_STRING ) ) )
            // InternalGaml.g:7240:2: ( (lv_op_0_0= RULE_STRING ) )
            {
            // InternalGaml.g:7240:2: ( (lv_op_0_0= RULE_STRING ) )
            // InternalGaml.g:7241:3: (lv_op_0_0= RULE_STRING )
            {
            // InternalGaml.g:7241:3: (lv_op_0_0= RULE_STRING )
            // InternalGaml.g:7242:4: lv_op_0_0= RULE_STRING
            {
            lv_op_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_op_0_0, grammarAccess.getStringLiteralAccess().getOpSTRINGTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getStringLiteralRule());
              				}
              				setWithLastConsumed(
              					current,
              					"op",
              					lv_op_0_0,
              					"gama.core.lang.Gaml.STRING");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"

    // $ANTLR start synpred1_InternalGaml
    public final void synpred1_InternalGaml_fragment() throws RecognitionException {   
        // InternalGaml.g:80:4: ( '@' | 'model' )
        // InternalGaml.g:
        {
        if ( input.LA(1)==16||input.LA(1)==19 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred1_InternalGaml

    // $ANTLR start synpred2_InternalGaml
    public final void synpred2_InternalGaml_fragment() throws RecognitionException {   
        // InternalGaml.g:1012:5: ( ruleS_Declaration )
        // InternalGaml.g:1012:6: ruleS_Declaration
        {
        pushFollow(FOLLOW_2);
        ruleS_Declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalGaml

    // $ANTLR start synpred3_InternalGaml
    public final void synpred3_InternalGaml_fragment() throws RecognitionException {   
        // InternalGaml.g:1025:6: ( ruleS_Assignment )
        // InternalGaml.g:1025:7: ruleS_Assignment
        {
        pushFollow(FOLLOW_2);
        ruleS_Assignment();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalGaml

    // $ANTLR start synpred4_InternalGaml
    public final void synpred4_InternalGaml_fragment() throws RecognitionException {   
        // InternalGaml.g:1484:5: ( 'else' )
        // InternalGaml.g:1484:6: 'else'
        {
        match(input,25,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalGaml

    // $ANTLR start synpred5_InternalGaml
    public final void synpred5_InternalGaml_fragment() throws RecognitionException {   
        // InternalGaml.g:1582:5: ( 'catch' )
        // InternalGaml.g:1582:6: 'catch'
        {
        match(input,27,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalGaml

    // $ANTLR start synpred6_InternalGaml
    public final void synpred6_InternalGaml_fragment() throws RecognitionException {   
        // InternalGaml.g:1766:4: ( 'species' | RULE_ID )
        // InternalGaml.g:
        {
        if ( input.LA(1)==RULE_ID||input.LA(1)==40 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred6_InternalGaml

    // $ANTLR start synpred8_InternalGaml
    public final void synpred8_InternalGaml_fragment() throws RecognitionException {   
        // InternalGaml.g:4105:5: ( ( ( ruleExpression ) ) )
        // InternalGaml.g:4105:6: ( ( ruleExpression ) )
        {
        // InternalGaml.g:4105:6: ( ( ruleExpression ) )
        // InternalGaml.g:4106:6: ( ruleExpression )
        {
        // InternalGaml.g:4106:6: ( ruleExpression )
        // InternalGaml.g:4107:7: ruleExpression
        {
        pushFollow(FOLLOW_2);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred8_InternalGaml

    // $ANTLR start synpred9_InternalGaml
    public final void synpred9_InternalGaml_fragment() throws RecognitionException {   
        // InternalGaml.g:4202:5: ( 'species' | RULE_ID )
        // InternalGaml.g:
        {
        if ( input.LA(1)==RULE_ID||input.LA(1)==40 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred9_InternalGaml

    // $ANTLR start synpred10_InternalGaml
    public final void synpred10_InternalGaml_fragment() throws RecognitionException {   
        // InternalGaml.g:4398:4: ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )
        // InternalGaml.g:4398:5: ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) )
        {
        // InternalGaml.g:4398:5: ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) )
        int alt119=2;
        int LA119_0 = input.LA(1);

        if ( (LA119_0==RULE_ID||LA119_0==38||(LA119_0>=40 && LA119_0<=87)) ) {
            alt119=1;
        }
        else if ( (LA119_0==29||(LA119_0>=95 && LA119_0<=118)) ) {
            alt119=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 119, 0, input);

            throw nvae;
        }
        switch (alt119) {
            case 1 :
                // InternalGaml.g:4399:5: ( ( ( ruleValid_ID ) ) '::' )
                {
                // InternalGaml.g:4399:5: ( ( ( ruleValid_ID ) ) '::' )
                // InternalGaml.g:4400:6: ( ( ruleValid_ID ) ) '::'
                {
                // InternalGaml.g:4400:6: ( ( ruleValid_ID ) )
                // InternalGaml.g:4401:7: ( ruleValid_ID )
                {
                // InternalGaml.g:4401:7: ( ruleValid_ID )
                // InternalGaml.g:4402:8: ruleValid_ID
                {
                pushFollow(FOLLOW_40);
                ruleValid_ID();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                match(input,120,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;
            case 2 :
                // InternalGaml.g:4408:5: ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' )
                {
                // InternalGaml.g:4408:5: ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' )
                // InternalGaml.g:4409:6: ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':'
                {
                // InternalGaml.g:4409:6: ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) )
                // InternalGaml.g:4410:7: ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) )
                {
                // InternalGaml.g:4410:7: ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) )
                // InternalGaml.g:4411:8: ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey )
                {
                // InternalGaml.g:4411:8: ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey )
                int alt118=4;
                switch ( input.LA(1) ) {
                case 95:
                case 96:
                    {
                    alt118=1;
                    }
                    break;
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                    {
                    alt118=2;
                    }
                    break;
                case 29:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                    {
                    alt118=3;
                    }
                    break;
                case 117:
                case 118:
                    {
                    alt118=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 118, 0, input);

                    throw nvae;
                }

                switch (alt118) {
                    case 1 :
                        // InternalGaml.g:4412:9: ruleDefinitionFacetKey
                        {
                        pushFollow(FOLLOW_24);
                        ruleDefinitionFacetKey();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;
                    case 2 :
                        // InternalGaml.g:4413:14: ruleTypeFacetKey
                        {
                        pushFollow(FOLLOW_24);
                        ruleTypeFacetKey();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;
                    case 3 :
                        // InternalGaml.g:4414:14: ruleSpecialFacetKey
                        {
                        pushFollow(FOLLOW_24);
                        ruleSpecialFacetKey();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;
                    case 4 :
                        // InternalGaml.g:4415:14: ruleActionFacetKey
                        {
                        pushFollow(FOLLOW_24);
                        ruleActionFacetKey();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;

                }


                }


                }

                match(input,30,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred10_InternalGaml

    // $ANTLR start synpred11_InternalGaml
    public final void synpred11_InternalGaml_fragment() throws RecognitionException {   
        // InternalGaml.g:4461:4: ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )
        // InternalGaml.g:4461:5: ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) )
        {
        // InternalGaml.g:4461:5: ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) )
        int alt121=2;
        int LA121_0 = input.LA(1);

        if ( (LA121_0==RULE_ID||LA121_0==38||(LA121_0>=40 && LA121_0<=87)) ) {
            alt121=1;
        }
        else if ( (LA121_0==29||(LA121_0>=95 && LA121_0<=118)) ) {
            alt121=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 121, 0, input);

            throw nvae;
        }
        switch (alt121) {
            case 1 :
                // InternalGaml.g:4462:5: ( ( ( ruleValid_ID ) ) '::' )
                {
                // InternalGaml.g:4462:5: ( ( ( ruleValid_ID ) ) '::' )
                // InternalGaml.g:4463:6: ( ( ruleValid_ID ) ) '::'
                {
                // InternalGaml.g:4463:6: ( ( ruleValid_ID ) )
                // InternalGaml.g:4464:7: ( ruleValid_ID )
                {
                // InternalGaml.g:4464:7: ( ruleValid_ID )
                // InternalGaml.g:4465:8: ruleValid_ID
                {
                pushFollow(FOLLOW_40);
                ruleValid_ID();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                match(input,120,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;
            case 2 :
                // InternalGaml.g:4471:5: ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' )
                {
                // InternalGaml.g:4471:5: ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' )
                // InternalGaml.g:4472:6: ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':'
                {
                // InternalGaml.g:4472:6: ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) )
                // InternalGaml.g:4473:7: ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) )
                {
                // InternalGaml.g:4473:7: ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) )
                // InternalGaml.g:4474:8: ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey )
                {
                // InternalGaml.g:4474:8: ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey )
                int alt120=4;
                switch ( input.LA(1) ) {
                case 95:
                case 96:
                    {
                    alt120=1;
                    }
                    break;
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                    {
                    alt120=2;
                    }
                    break;
                case 29:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                    {
                    alt120=3;
                    }
                    break;
                case 117:
                case 118:
                    {
                    alt120=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 120, 0, input);

                    throw nvae;
                }

                switch (alt120) {
                    case 1 :
                        // InternalGaml.g:4475:9: ruleDefinitionFacetKey
                        {
                        pushFollow(FOLLOW_24);
                        ruleDefinitionFacetKey();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;
                    case 2 :
                        // InternalGaml.g:4476:14: ruleTypeFacetKey
                        {
                        pushFollow(FOLLOW_24);
                        ruleTypeFacetKey();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;
                    case 3 :
                        // InternalGaml.g:4477:14: ruleSpecialFacetKey
                        {
                        pushFollow(FOLLOW_24);
                        ruleSpecialFacetKey();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;
                    case 4 :
                        // InternalGaml.g:4478:14: ruleActionFacetKey
                        {
                        pushFollow(FOLLOW_24);
                        ruleActionFacetKey();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;

                }


                }


                }

                match(input,30,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred11_InternalGaml

    // $ANTLR start synpred12_InternalGaml
    public final void synpred12_InternalGaml_fragment() throws RecognitionException {   
        // InternalGaml.g:6021:4: ( ruleFunction )
        // InternalGaml.g:6021:5: ruleFunction
        {
        pushFollow(FOLLOW_2);
        ruleFunction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalGaml

    // $ANTLR start synpred13_InternalGaml
    public final void synpred13_InternalGaml_fragment() throws RecognitionException {   
        // InternalGaml.g:6440:4: ( '>' )
        // InternalGaml.g:6440:5: '>'
        {
        match(input,89,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalGaml

    // $ANTLR start synpred14_InternalGaml
    public final void synpred14_InternalGaml_fragment() throws RecognitionException {   
        // InternalGaml.g:6622:4: ( ruleS_Declaration )
        // InternalGaml.g:6622:5: ruleS_Declaration
        {
        pushFollow(FOLLOW_2);
        ruleS_Declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalGaml

    // Delegated rules

    public final boolean synpred9_InternalGaml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalGaml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalGaml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalGaml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalGaml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalGaml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalGaml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalGaml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalGaml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalGaml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalGaml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalGaml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalGaml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalGaml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalGaml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalGaml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalGaml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalGaml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalGaml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalGaml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalGaml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalGaml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalGaml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalGaml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalGaml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalGaml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA19 dfa19 = new DFA19(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA71 dfa71 = new DFA71(this);
    protected DFA72 dfa72 = new DFA72(this);
    protected DFA75 dfa75 = new DFA75(this);
    protected DFA78 dfa78 = new DFA78(this);
    protected DFA104 dfa104 = new DFA104(this);
    protected DFA114 dfa114 = new DFA114(this);
    static final String dfa_1s = "\140\uffff";
    static final String dfa_2s = "\1\4\6\0\131\uffff";
    static final String dfa_3s = "\1\u008a\6\0\131\uffff";
    static final String dfa_4s = "\7\uffff\2\1\1\2\126\uffff";
    static final String dfa_5s = "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\131\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\5\11\15\uffff\1\10\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11\1\uffff\1\7\1\11\3\uffff\2\11\1\2\1\3\53\11\1\4\1\5\1\6\7\uffff\30\11\12\uffff\1\11\3\uffff\6\11",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1010:3: ( ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration ) | ( ( ( ruleS_Assignment )=>this_S_Assignment_1= ruleS_Assignment ) | this_S_1Expr_Facets_BlockOrEnd_2= ruleS_1Expr_Facets_BlockOrEnd | this_S_Other_3= ruleS_Other | this_S_Do_4= ruleS_Do | this_S_Return_5= ruleS_Return | this_S_Solve_6= ruleS_Solve | this_S_If_7= ruleS_If | this_S_Try_8= ruleS_Try | this_S_Equations_9= ruleS_Equations ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_0 = input.LA(1);

                         
                        int index19_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_0==RULE_ID) ) {s = 1;}

                        else if ( (LA19_0==40) ) {s = 2;}

                        else if ( (LA19_0==41) ) {s = 3;}

                        else if ( (LA19_0==85) ) {s = 4;}

                        else if ( (LA19_0==86) ) {s = 5;}

                        else if ( (LA19_0==87) ) {s = 6;}

                        else if ( (LA19_0==33) && (synpred2_InternalGaml())) {s = 7;}

                        else if ( (LA19_0==23) && (synpred2_InternalGaml())) {s = 8;}

                        else if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_KEYWORD)||LA19_0==24||LA19_0==26||(LA19_0>=28 && LA19_0<=29)||LA19_0==31||LA19_0==34||(LA19_0>=38 && LA19_0<=39)||(LA19_0>=42 && LA19_0<=84)||(LA19_0>=95 && LA19_0<=118)||LA19_0==129||(LA19_0>=133 && LA19_0<=138)) ) {s = 9;}

                         
                        input.seek(index19_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_1 = input.LA(1);

                         
                        int index19_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalGaml()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index19_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_2 = input.LA(1);

                         
                        int index19_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalGaml()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index19_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA19_3 = input.LA(1);

                         
                        int index19_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalGaml()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index19_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA19_4 = input.LA(1);

                         
                        int index19_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalGaml()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index19_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA19_5 = input.LA(1);

                         
                        int index19_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalGaml()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index19_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA19_6 = input.LA(1);

                         
                        int index19_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalGaml()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index19_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\142\uffff";
    static final String dfa_8s = "\1\4\2\uffff\2\0\3\uffff\52\0\60\uffff";
    static final String dfa_9s = "\1\u008a\2\uffff\2\0\3\uffff\52\0\60\uffff";
    static final String dfa_10s = "\1\uffff\2\1\2\uffff\3\1\52\uffff\50\1\1\5\1\6\1\7\1\10\1\4\1\2\1\11\1\3";
    static final String dfa_11s = "\1\0\2\uffff\1\1\1\2\3\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\60\uffff}>";
    static final String[] dfa_12s = {
            "\1\61\1\114\1\115\1\116\1\117\1\120\16\uffff\1\134\1\uffff\1\135\1\uffff\1\132\1\73\1\uffff\1\121\2\uffff\1\123\3\uffff\1\60\1\133\1\1\1\2\1\62\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\3\1\4\1\5\1\6\1\7\7\uffff\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\12\uffff\1\125\3\uffff\1\124\1\126\1\127\1\130\1\131\1\122",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "1023:4: ( ( ( ruleS_Assignment )=>this_S_Assignment_1= ruleS_Assignment ) | this_S_1Expr_Facets_BlockOrEnd_2= ruleS_1Expr_Facets_BlockOrEnd | this_S_Other_3= ruleS_Other | this_S_Do_4= ruleS_Do | this_S_Return_5= ruleS_Return | this_S_Solve_6= ruleS_Solve | this_S_If_7= ruleS_If | this_S_Try_8= ruleS_Try | this_S_Equations_9= ruleS_Equations )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_0 = input.LA(1);

                         
                        int index18_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA18_0==40) && (synpred3_InternalGaml())) {s = 1;}

                        else if ( (LA18_0==41) && (synpred3_InternalGaml())) {s = 2;}

                        else if ( (LA18_0==83) ) {s = 3;}

                        else if ( (LA18_0==84) ) {s = 4;}

                        else if ( (LA18_0==85) && (synpred3_InternalGaml())) {s = 5;}

                        else if ( (LA18_0==86) && (synpred3_InternalGaml())) {s = 6;}

                        else if ( (LA18_0==87) && (synpred3_InternalGaml())) {s = 7;}

                        else if ( (LA18_0==69) ) {s = 8;}

                        else if ( (LA18_0==70) ) {s = 9;}

                        else if ( (LA18_0==71) ) {s = 10;}

                        else if ( (LA18_0==72) ) {s = 11;}

                        else if ( (LA18_0==73) ) {s = 12;}

                        else if ( (LA18_0==74) ) {s = 13;}

                        else if ( (LA18_0==75) ) {s = 14;}

                        else if ( (LA18_0==76) ) {s = 15;}

                        else if ( (LA18_0==77) ) {s = 16;}

                        else if ( (LA18_0==78) ) {s = 17;}

                        else if ( (LA18_0==79) ) {s = 18;}

                        else if ( (LA18_0==80) ) {s = 19;}

                        else if ( (LA18_0==81) ) {s = 20;}

                        else if ( (LA18_0==82) ) {s = 21;}

                        else if ( (LA18_0==43) ) {s = 22;}

                        else if ( (LA18_0==44) ) {s = 23;}

                        else if ( (LA18_0==45) ) {s = 24;}

                        else if ( (LA18_0==46) ) {s = 25;}

                        else if ( (LA18_0==47) ) {s = 26;}

                        else if ( (LA18_0==48) ) {s = 27;}

                        else if ( (LA18_0==49) ) {s = 28;}

                        else if ( (LA18_0==50) ) {s = 29;}

                        else if ( (LA18_0==51) ) {s = 30;}

                        else if ( (LA18_0==52) ) {s = 31;}

                        else if ( (LA18_0==53) ) {s = 32;}

                        else if ( (LA18_0==54) ) {s = 33;}

                        else if ( (LA18_0==55) ) {s = 34;}

                        else if ( (LA18_0==56) ) {s = 35;}

                        else if ( (LA18_0==57) ) {s = 36;}

                        else if ( (LA18_0==58) ) {s = 37;}

                        else if ( (LA18_0==59) ) {s = 38;}

                        else if ( (LA18_0==60) ) {s = 39;}

                        else if ( (LA18_0==61) ) {s = 40;}

                        else if ( (LA18_0==62) ) {s = 41;}

                        else if ( (LA18_0==63) ) {s = 42;}

                        else if ( (LA18_0==64) ) {s = 43;}

                        else if ( (LA18_0==65) ) {s = 44;}

                        else if ( (LA18_0==66) ) {s = 45;}

                        else if ( (LA18_0==67) ) {s = 46;}

                        else if ( (LA18_0==68) ) {s = 47;}

                        else if ( (LA18_0==38) ) {s = 48;}

                        else if ( (LA18_0==RULE_ID) ) {s = 49;}

                        else if ( (LA18_0==42) && (synpred3_InternalGaml())) {s = 50;}

                        else if ( (LA18_0==95) && (synpred3_InternalGaml())) {s = 51;}

                        else if ( (LA18_0==96) && (synpred3_InternalGaml())) {s = 52;}

                        else if ( (LA18_0==97) && (synpred3_InternalGaml())) {s = 53;}

                        else if ( (LA18_0==98) && (synpred3_InternalGaml())) {s = 54;}

                        else if ( (LA18_0==99) && (synpred3_InternalGaml())) {s = 55;}

                        else if ( (LA18_0==100) && (synpred3_InternalGaml())) {s = 56;}

                        else if ( (LA18_0==101) && (synpred3_InternalGaml())) {s = 57;}

                        else if ( (LA18_0==102) && (synpred3_InternalGaml())) {s = 58;}

                        else if ( (LA18_0==29) && (synpred3_InternalGaml())) {s = 59;}

                        else if ( (LA18_0==103) && (synpred3_InternalGaml())) {s = 60;}

                        else if ( (LA18_0==104) && (synpred3_InternalGaml())) {s = 61;}

                        else if ( (LA18_0==105) && (synpred3_InternalGaml())) {s = 62;}

                        else if ( (LA18_0==106) && (synpred3_InternalGaml())) {s = 63;}

                        else if ( (LA18_0==107) && (synpred3_InternalGaml())) {s = 64;}

                        else if ( (LA18_0==108) && (synpred3_InternalGaml())) {s = 65;}

                        else if ( (LA18_0==109) && (synpred3_InternalGaml())) {s = 66;}

                        else if ( (LA18_0==110) && (synpred3_InternalGaml())) {s = 67;}

                        else if ( (LA18_0==111) && (synpred3_InternalGaml())) {s = 68;}

                        else if ( (LA18_0==112) && (synpred3_InternalGaml())) {s = 69;}

                        else if ( (LA18_0==113) && (synpred3_InternalGaml())) {s = 70;}

                        else if ( (LA18_0==114) && (synpred3_InternalGaml())) {s = 71;}

                        else if ( (LA18_0==115) && (synpred3_InternalGaml())) {s = 72;}

                        else if ( (LA18_0==116) && (synpred3_InternalGaml())) {s = 73;}

                        else if ( (LA18_0==117) && (synpred3_InternalGaml())) {s = 74;}

                        else if ( (LA18_0==118) && (synpred3_InternalGaml())) {s = 75;}

                        else if ( (LA18_0==RULE_STRING) && (synpred3_InternalGaml())) {s = 76;}

                        else if ( (LA18_0==RULE_INTEGER) && (synpred3_InternalGaml())) {s = 77;}

                        else if ( (LA18_0==RULE_DOUBLE) && (synpred3_InternalGaml())) {s = 78;}

                        else if ( (LA18_0==RULE_BOOLEAN) && (synpred3_InternalGaml())) {s = 79;}

                        else if ( (LA18_0==RULE_KEYWORD) && (synpred3_InternalGaml())) {s = 80;}

                        else if ( (LA18_0==31) && (synpred3_InternalGaml())) {s = 81;}

                        else if ( (LA18_0==138) && (synpred3_InternalGaml())) {s = 82;}

                        else if ( (LA18_0==34) && (synpred3_InternalGaml())) {s = 83;}

                        else if ( (LA18_0==133) && (synpred3_InternalGaml())) {s = 84;}

                        else if ( (LA18_0==129) && (synpred3_InternalGaml())) {s = 85;}

                        else if ( (LA18_0==134) && (synpred3_InternalGaml())) {s = 86;}

                        else if ( (LA18_0==135) && (synpred3_InternalGaml())) {s = 87;}

                        else if ( (LA18_0==136) && (synpred3_InternalGaml())) {s = 88;}

                        else if ( (LA18_0==137) && (synpred3_InternalGaml())) {s = 89;}

                        else if ( (LA18_0==28) ) {s = 90;}

                        else if ( (LA18_0==39) ) {s = 91;}

                        else if ( (LA18_0==24) ) {s = 92;}

                        else if ( (LA18_0==26) ) {s = 93;}

                         
                        input.seek(index18_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_3 = input.LA(1);

                         
                        int index18_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 94;}

                         
                        input.seek(index18_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_4 = input.LA(1);

                         
                        int index18_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 94;}

                         
                        input.seek(index18_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_8 = input.LA(1);

                         
                        int index18_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA18_9 = input.LA(1);

                         
                        int index18_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_9);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA18_10 = input.LA(1);

                         
                        int index18_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_10);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA18_11 = input.LA(1);

                         
                        int index18_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_11);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA18_12 = input.LA(1);

                         
                        int index18_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_12);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA18_13 = input.LA(1);

                         
                        int index18_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_13);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA18_14 = input.LA(1);

                         
                        int index18_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_14);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA18_15 = input.LA(1);

                         
                        int index18_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_15);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA18_16 = input.LA(1);

                         
                        int index18_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_16);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA18_17 = input.LA(1);

                         
                        int index18_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_17);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA18_18 = input.LA(1);

                         
                        int index18_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_18);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA18_19 = input.LA(1);

                         
                        int index18_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_19);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA18_20 = input.LA(1);

                         
                        int index18_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_20);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA18_21 = input.LA(1);

                         
                        int index18_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_21);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA18_22 = input.LA(1);

                         
                        int index18_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_22);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA18_23 = input.LA(1);

                         
                        int index18_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_23);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA18_24 = input.LA(1);

                         
                        int index18_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_24);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA18_25 = input.LA(1);

                         
                        int index18_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_25);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA18_26 = input.LA(1);

                         
                        int index18_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_26);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA18_27 = input.LA(1);

                         
                        int index18_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_27);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA18_28 = input.LA(1);

                         
                        int index18_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_28);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA18_29 = input.LA(1);

                         
                        int index18_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_29);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA18_30 = input.LA(1);

                         
                        int index18_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_30);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA18_31 = input.LA(1);

                         
                        int index18_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_31);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA18_32 = input.LA(1);

                         
                        int index18_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_32);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA18_33 = input.LA(1);

                         
                        int index18_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_33);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA18_34 = input.LA(1);

                         
                        int index18_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_34);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA18_35 = input.LA(1);

                         
                        int index18_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_35);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA18_36 = input.LA(1);

                         
                        int index18_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_36);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA18_37 = input.LA(1);

                         
                        int index18_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_37);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA18_38 = input.LA(1);

                         
                        int index18_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_38);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA18_39 = input.LA(1);

                         
                        int index18_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_39);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA18_40 = input.LA(1);

                         
                        int index18_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_40);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA18_41 = input.LA(1);

                         
                        int index18_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_41);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA18_42 = input.LA(1);

                         
                        int index18_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_42);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA18_43 = input.LA(1);

                         
                        int index18_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_43);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA18_44 = input.LA(1);

                         
                        int index18_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_44);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA18_45 = input.LA(1);

                         
                        int index18_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_45);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA18_46 = input.LA(1);

                         
                        int index18_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_46);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA18_47 = input.LA(1);

                         
                        int index18_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index18_47);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA18_48 = input.LA(1);

                         
                        int index18_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 96;}

                         
                        input.seek(index18_48);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA18_49 = input.LA(1);

                         
                        int index18_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 97;}

                         
                        input.seek(index18_49);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_13s = "\65\uffff";
    static final String dfa_14s = "\1\4\62\37\2\uffff";
    static final String dfa_15s = "\1\127\62\177\2\uffff";
    static final String dfa_16s = "\63\uffff\1\1\1\2";
    static final String dfa_17s = "\65\uffff}>";
    static final String[] dfa_18s = {
            "\1\61\41\uffff\1\60\1\uffff\1\1\1\2\1\62\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\3\1\4\1\5\1\6\1\7",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "\1\63\4\uffff\1\64\132\uffff\1\63",
            "",
            ""
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "2436:5: (lv_expr_0_1= ruleFunction | lv_expr_0_2= ruleVariableRef )";
        }
    }
    static final String dfa_19s = "\12\uffff";
    static final String dfa_20s = "\1\17\2\uffff\1\131\6\uffff";
    static final String dfa_21s = "\1\135\2\uffff\1\133\6\uffff";
    static final String dfa_22s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\6\1\7\1\10\1\5\1\3";
    static final String dfa_23s = "\12\uffff}>";
    static final String[] dfa_24s = {
            "\1\1\110\uffff\1\2\1\3\1\4\1\7\1\5\1\6",
            "",
            "",
            "\1\11\1\uffff\1\10",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final char[] dfa_20 = DFA.unpackEncodedStringToUnsignedChars(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[][] dfa_24 = unpackEncodedStringArray(dfa_24s);

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = dfa_19;
            this.eof = dfa_19;
            this.min = dfa_20;
            this.max = dfa_21;
            this.accept = dfa_22;
            this.special = dfa_23;
            this.transition = dfa_24;
        }
        public String getDescription() {
            return "3371:2: (kw= '<-' | kw= '<<' | (kw= '>' kw= '>' ) | kw= '<<+' | (kw= '>' kw= '>-' ) | kw= '+<-' | kw= '<+' | kw= '>-' )";
        }
    }
    static final String dfa_25s = "\133\uffff";
    static final String dfa_26s = "\1\4\122\uffff\1\0\7\uffff";
    static final String dfa_27s = "\1\u008a\122\uffff\1\0\7\uffff";
    static final String dfa_28s = "\1\uffff\122\1\1\uffff\6\1\1\2";
    static final String dfa_29s = "\1\0\122\uffff\1\1\7\uffff}>";
    static final String[] dfa_30s = {
            "\1\61\1\114\1\115\1\116\1\117\1\120\23\uffff\1\73\1\uffff\1\121\2\uffff\1\123\3\uffff\1\60\1\uffff\1\1\1\2\1\62\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\3\1\4\1\5\1\6\1\7\7\uffff\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\12\uffff\1\125\3\uffff\1\124\1\126\1\127\1\130\1\131\1\122",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[][] dfa_30 = unpackEncodedStringArray(dfa_30s);

    class DFA71 extends DFA {

        public DFA71(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 71;
            this.eot = dfa_25;
            this.eof = dfa_25;
            this.min = dfa_26;
            this.max = dfa_27;
            this.accept = dfa_28;
            this.special = dfa_29;
            this.transition = dfa_30;
        }
        public String getDescription() {
            return "4103:3: ( ( ( ( ( ruleExpression ) ) )=> ( (lv_expr_1_0= ruleExpression ) ) ) | (otherlv_2= '{' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= '}' ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA71_0 = input.LA(1);

                         
                        int index71_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA71_0==40) && (synpred8_InternalGaml())) {s = 1;}

                        else if ( (LA71_0==41) && (synpred8_InternalGaml())) {s = 2;}

                        else if ( (LA71_0==83) && (synpred8_InternalGaml())) {s = 3;}

                        else if ( (LA71_0==84) && (synpred8_InternalGaml())) {s = 4;}

                        else if ( (LA71_0==85) && (synpred8_InternalGaml())) {s = 5;}

                        else if ( (LA71_0==86) && (synpred8_InternalGaml())) {s = 6;}

                        else if ( (LA71_0==87) && (synpred8_InternalGaml())) {s = 7;}

                        else if ( (LA71_0==69) && (synpred8_InternalGaml())) {s = 8;}

                        else if ( (LA71_0==70) && (synpred8_InternalGaml())) {s = 9;}

                        else if ( (LA71_0==71) && (synpred8_InternalGaml())) {s = 10;}

                        else if ( (LA71_0==72) && (synpred8_InternalGaml())) {s = 11;}

                        else if ( (LA71_0==73) && (synpred8_InternalGaml())) {s = 12;}

                        else if ( (LA71_0==74) && (synpred8_InternalGaml())) {s = 13;}

                        else if ( (LA71_0==75) && (synpred8_InternalGaml())) {s = 14;}

                        else if ( (LA71_0==76) && (synpred8_InternalGaml())) {s = 15;}

                        else if ( (LA71_0==77) && (synpred8_InternalGaml())) {s = 16;}

                        else if ( (LA71_0==78) && (synpred8_InternalGaml())) {s = 17;}

                        else if ( (LA71_0==79) && (synpred8_InternalGaml())) {s = 18;}

                        else if ( (LA71_0==80) && (synpred8_InternalGaml())) {s = 19;}

                        else if ( (LA71_0==81) && (synpred8_InternalGaml())) {s = 20;}

                        else if ( (LA71_0==82) && (synpred8_InternalGaml())) {s = 21;}

                        else if ( (LA71_0==43) && (synpred8_InternalGaml())) {s = 22;}

                        else if ( (LA71_0==44) && (synpred8_InternalGaml())) {s = 23;}

                        else if ( (LA71_0==45) && (synpred8_InternalGaml())) {s = 24;}

                        else if ( (LA71_0==46) && (synpred8_InternalGaml())) {s = 25;}

                        else if ( (LA71_0==47) && (synpred8_InternalGaml())) {s = 26;}

                        else if ( (LA71_0==48) && (synpred8_InternalGaml())) {s = 27;}

                        else if ( (LA71_0==49) && (synpred8_InternalGaml())) {s = 28;}

                        else if ( (LA71_0==50) && (synpred8_InternalGaml())) {s = 29;}

                        else if ( (LA71_0==51) && (synpred8_InternalGaml())) {s = 30;}

                        else if ( (LA71_0==52) && (synpred8_InternalGaml())) {s = 31;}

                        else if ( (LA71_0==53) && (synpred8_InternalGaml())) {s = 32;}

                        else if ( (LA71_0==54) && (synpred8_InternalGaml())) {s = 33;}

                        else if ( (LA71_0==55) && (synpred8_InternalGaml())) {s = 34;}

                        else if ( (LA71_0==56) && (synpred8_InternalGaml())) {s = 35;}

                        else if ( (LA71_0==57) && (synpred8_InternalGaml())) {s = 36;}

                        else if ( (LA71_0==58) && (synpred8_InternalGaml())) {s = 37;}

                        else if ( (LA71_0==59) && (synpred8_InternalGaml())) {s = 38;}

                        else if ( (LA71_0==60) && (synpred8_InternalGaml())) {s = 39;}

                        else if ( (LA71_0==61) && (synpred8_InternalGaml())) {s = 40;}

                        else if ( (LA71_0==62) && (synpred8_InternalGaml())) {s = 41;}

                        else if ( (LA71_0==63) && (synpred8_InternalGaml())) {s = 42;}

                        else if ( (LA71_0==64) && (synpred8_InternalGaml())) {s = 43;}

                        else if ( (LA71_0==65) && (synpred8_InternalGaml())) {s = 44;}

                        else if ( (LA71_0==66) && (synpred8_InternalGaml())) {s = 45;}

                        else if ( (LA71_0==67) && (synpred8_InternalGaml())) {s = 46;}

                        else if ( (LA71_0==68) && (synpred8_InternalGaml())) {s = 47;}

                        else if ( (LA71_0==38) && (synpred8_InternalGaml())) {s = 48;}

                        else if ( (LA71_0==RULE_ID) && (synpred8_InternalGaml())) {s = 49;}

                        else if ( (LA71_0==42) && (synpred8_InternalGaml())) {s = 50;}

                        else if ( (LA71_0==95) && (synpred8_InternalGaml())) {s = 51;}

                        else if ( (LA71_0==96) && (synpred8_InternalGaml())) {s = 52;}

                        else if ( (LA71_0==97) && (synpred8_InternalGaml())) {s = 53;}

                        else if ( (LA71_0==98) && (synpred8_InternalGaml())) {s = 54;}

                        else if ( (LA71_0==99) && (synpred8_InternalGaml())) {s = 55;}

                        else if ( (LA71_0==100) && (synpred8_InternalGaml())) {s = 56;}

                        else if ( (LA71_0==101) && (synpred8_InternalGaml())) {s = 57;}

                        else if ( (LA71_0==102) && (synpred8_InternalGaml())) {s = 58;}

                        else if ( (LA71_0==29) && (synpred8_InternalGaml())) {s = 59;}

                        else if ( (LA71_0==103) && (synpred8_InternalGaml())) {s = 60;}

                        else if ( (LA71_0==104) && (synpred8_InternalGaml())) {s = 61;}

                        else if ( (LA71_0==105) && (synpred8_InternalGaml())) {s = 62;}

                        else if ( (LA71_0==106) && (synpred8_InternalGaml())) {s = 63;}

                        else if ( (LA71_0==107) && (synpred8_InternalGaml())) {s = 64;}

                        else if ( (LA71_0==108) && (synpred8_InternalGaml())) {s = 65;}

                        else if ( (LA71_0==109) && (synpred8_InternalGaml())) {s = 66;}

                        else if ( (LA71_0==110) && (synpred8_InternalGaml())) {s = 67;}

                        else if ( (LA71_0==111) && (synpred8_InternalGaml())) {s = 68;}

                        else if ( (LA71_0==112) && (synpred8_InternalGaml())) {s = 69;}

                        else if ( (LA71_0==113) && (synpred8_InternalGaml())) {s = 70;}

                        else if ( (LA71_0==114) && (synpred8_InternalGaml())) {s = 71;}

                        else if ( (LA71_0==115) && (synpred8_InternalGaml())) {s = 72;}

                        else if ( (LA71_0==116) && (synpred8_InternalGaml())) {s = 73;}

                        else if ( (LA71_0==117) && (synpred8_InternalGaml())) {s = 74;}

                        else if ( (LA71_0==118) && (synpred8_InternalGaml())) {s = 75;}

                        else if ( (LA71_0==RULE_STRING) && (synpred8_InternalGaml())) {s = 76;}

                        else if ( (LA71_0==RULE_INTEGER) && (synpred8_InternalGaml())) {s = 77;}

                        else if ( (LA71_0==RULE_DOUBLE) && (synpred8_InternalGaml())) {s = 78;}

                        else if ( (LA71_0==RULE_BOOLEAN) && (synpred8_InternalGaml())) {s = 79;}

                        else if ( (LA71_0==RULE_KEYWORD) && (synpred8_InternalGaml())) {s = 80;}

                        else if ( (LA71_0==31) && (synpred8_InternalGaml())) {s = 81;}

                        else if ( (LA71_0==138) && (synpred8_InternalGaml())) {s = 82;}

                        else if ( (LA71_0==34) ) {s = 83;}

                        else if ( (LA71_0==133) && (synpred8_InternalGaml())) {s = 84;}

                        else if ( (LA71_0==129) && (synpred8_InternalGaml())) {s = 85;}

                        else if ( (LA71_0==134) && (synpred8_InternalGaml())) {s = 86;}

                        else if ( (LA71_0==135) && (synpred8_InternalGaml())) {s = 87;}

                        else if ( (LA71_0==136) && (synpred8_InternalGaml())) {s = 88;}

                        else if ( (LA71_0==137) && (synpred8_InternalGaml())) {s = 89;}

                         
                        input.seek(index71_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA71_83 = input.LA(1);

                         
                        int index71_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalGaml()) ) {s = 89;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index71_83);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 71, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_31s = "\1\4\2\0\130\uffff";
    static final String dfa_32s = "\1\u008a\2\0\130\uffff";
    static final String dfa_33s = "\3\uffff\1\2\126\uffff\1\1";
    static final String dfa_34s = "\1\uffff\1\0\1\1\130\uffff}>";
    static final String[] dfa_35s = {
            "\1\1\5\3\23\uffff\1\3\1\uffff\1\3\2\uffff\1\3\3\uffff\1\3\1\uffff\1\2\57\3\7\uffff\30\3\12\uffff\1\3\3\uffff\6\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final short[][] dfa_35 = unpackEncodedStringArray(dfa_35s);

    class DFA72 extends DFA {

        public DFA72(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 72;
            this.eot = dfa_25;
            this.eof = dfa_25;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_34;
            this.transition = dfa_35;
        }
        public String getDescription() {
            return "4200:3: ( ( ( 'species' | RULE_ID )=> ( (lv_expr_1_0= ruleTypeRef ) ) ) | ( (lv_expr_2_0= ruleExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA72_1 = input.LA(1);

                         
                        int index72_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalGaml()) ) {s = 90;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index72_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA72_2 = input.LA(1);

                         
                        int index72_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalGaml()) ) {s = 90;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index72_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 72, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_36s = "\1\4\62\0\31\uffff\16\0\1\uffff";
    static final String dfa_37s = "\1\u008a\62\0\31\uffff\16\0\1\uffff";
    static final String dfa_38s = "\63\uffff\31\1\16\uffff\1\2";
    static final String dfa_39s = "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\31\uffff\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\uffff}>";
    static final String[] dfa_40s = {
            "\1\61\1\114\1\115\1\116\1\117\1\120\23\uffff\1\73\1\uffff\1\121\2\uffff\1\123\3\uffff\1\60\1\uffff\1\1\1\2\1\62\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\3\1\4\1\5\1\6\1\7\7\uffff\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\12\uffff\1\125\3\uffff\1\124\1\126\1\127\1\130\1\131\1\122",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final char[] dfa_37 = DFA.unpackEncodedStringToUnsignedChars(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final short[][] dfa_40 = unpackEncodedStringArray(dfa_40s);

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = dfa_25;
            this.eof = dfa_25;
            this.min = dfa_36;
            this.max = dfa_37;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_40;
        }
        public String getDescription() {
            return "4396:2: ( ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=>this_ArgumentPair_0= ruleArgumentPair ) | this_Pair_1= rulePair )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA75_0 = input.LA(1);

                         
                        int index75_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA75_0==40) ) {s = 1;}

                        else if ( (LA75_0==41) ) {s = 2;}

                        else if ( (LA75_0==83) ) {s = 3;}

                        else if ( (LA75_0==84) ) {s = 4;}

                        else if ( (LA75_0==85) ) {s = 5;}

                        else if ( (LA75_0==86) ) {s = 6;}

                        else if ( (LA75_0==87) ) {s = 7;}

                        else if ( (LA75_0==69) ) {s = 8;}

                        else if ( (LA75_0==70) ) {s = 9;}

                        else if ( (LA75_0==71) ) {s = 10;}

                        else if ( (LA75_0==72) ) {s = 11;}

                        else if ( (LA75_0==73) ) {s = 12;}

                        else if ( (LA75_0==74) ) {s = 13;}

                        else if ( (LA75_0==75) ) {s = 14;}

                        else if ( (LA75_0==76) ) {s = 15;}

                        else if ( (LA75_0==77) ) {s = 16;}

                        else if ( (LA75_0==78) ) {s = 17;}

                        else if ( (LA75_0==79) ) {s = 18;}

                        else if ( (LA75_0==80) ) {s = 19;}

                        else if ( (LA75_0==81) ) {s = 20;}

                        else if ( (LA75_0==82) ) {s = 21;}

                        else if ( (LA75_0==43) ) {s = 22;}

                        else if ( (LA75_0==44) ) {s = 23;}

                        else if ( (LA75_0==45) ) {s = 24;}

                        else if ( (LA75_0==46) ) {s = 25;}

                        else if ( (LA75_0==47) ) {s = 26;}

                        else if ( (LA75_0==48) ) {s = 27;}

                        else if ( (LA75_0==49) ) {s = 28;}

                        else if ( (LA75_0==50) ) {s = 29;}

                        else if ( (LA75_0==51) ) {s = 30;}

                        else if ( (LA75_0==52) ) {s = 31;}

                        else if ( (LA75_0==53) ) {s = 32;}

                        else if ( (LA75_0==54) ) {s = 33;}

                        else if ( (LA75_0==55) ) {s = 34;}

                        else if ( (LA75_0==56) ) {s = 35;}

                        else if ( (LA75_0==57) ) {s = 36;}

                        else if ( (LA75_0==58) ) {s = 37;}

                        else if ( (LA75_0==59) ) {s = 38;}

                        else if ( (LA75_0==60) ) {s = 39;}

                        else if ( (LA75_0==61) ) {s = 40;}

                        else if ( (LA75_0==62) ) {s = 41;}

                        else if ( (LA75_0==63) ) {s = 42;}

                        else if ( (LA75_0==64) ) {s = 43;}

                        else if ( (LA75_0==65) ) {s = 44;}

                        else if ( (LA75_0==66) ) {s = 45;}

                        else if ( (LA75_0==67) ) {s = 46;}

                        else if ( (LA75_0==68) ) {s = 47;}

                        else if ( (LA75_0==38) ) {s = 48;}

                        else if ( (LA75_0==RULE_ID) ) {s = 49;}

                        else if ( (LA75_0==42) ) {s = 50;}

                        else if ( (LA75_0==95) && (synpred10_InternalGaml())) {s = 51;}

                        else if ( (LA75_0==96) && (synpred10_InternalGaml())) {s = 52;}

                        else if ( (LA75_0==97) && (synpred10_InternalGaml())) {s = 53;}

                        else if ( (LA75_0==98) && (synpred10_InternalGaml())) {s = 54;}

                        else if ( (LA75_0==99) && (synpred10_InternalGaml())) {s = 55;}

                        else if ( (LA75_0==100) && (synpred10_InternalGaml())) {s = 56;}

                        else if ( (LA75_0==101) && (synpred10_InternalGaml())) {s = 57;}

                        else if ( (LA75_0==102) && (synpred10_InternalGaml())) {s = 58;}

                        else if ( (LA75_0==29) && (synpred10_InternalGaml())) {s = 59;}

                        else if ( (LA75_0==103) && (synpred10_InternalGaml())) {s = 60;}

                        else if ( (LA75_0==104) && (synpred10_InternalGaml())) {s = 61;}

                        else if ( (LA75_0==105) && (synpred10_InternalGaml())) {s = 62;}

                        else if ( (LA75_0==106) && (synpred10_InternalGaml())) {s = 63;}

                        else if ( (LA75_0==107) && (synpred10_InternalGaml())) {s = 64;}

                        else if ( (LA75_0==108) && (synpred10_InternalGaml())) {s = 65;}

                        else if ( (LA75_0==109) && (synpred10_InternalGaml())) {s = 66;}

                        else if ( (LA75_0==110) && (synpred10_InternalGaml())) {s = 67;}

                        else if ( (LA75_0==111) && (synpred10_InternalGaml())) {s = 68;}

                        else if ( (LA75_0==112) && (synpred10_InternalGaml())) {s = 69;}

                        else if ( (LA75_0==113) && (synpred10_InternalGaml())) {s = 70;}

                        else if ( (LA75_0==114) && (synpred10_InternalGaml())) {s = 71;}

                        else if ( (LA75_0==115) && (synpred10_InternalGaml())) {s = 72;}

                        else if ( (LA75_0==116) && (synpred10_InternalGaml())) {s = 73;}

                        else if ( (LA75_0==117) && (synpred10_InternalGaml())) {s = 74;}

                        else if ( (LA75_0==118) && (synpred10_InternalGaml())) {s = 75;}

                        else if ( (LA75_0==RULE_STRING) ) {s = 76;}

                        else if ( (LA75_0==RULE_INTEGER) ) {s = 77;}

                        else if ( (LA75_0==RULE_DOUBLE) ) {s = 78;}

                        else if ( (LA75_0==RULE_BOOLEAN) ) {s = 79;}

                        else if ( (LA75_0==RULE_KEYWORD) ) {s = 80;}

                        else if ( (LA75_0==31) ) {s = 81;}

                        else if ( (LA75_0==138) ) {s = 82;}

                        else if ( (LA75_0==34) ) {s = 83;}

                        else if ( (LA75_0==133) ) {s = 84;}

                        else if ( (LA75_0==129) ) {s = 85;}

                        else if ( (LA75_0==134) ) {s = 86;}

                        else if ( (LA75_0==135) ) {s = 87;}

                        else if ( (LA75_0==136) ) {s = 88;}

                        else if ( (LA75_0==137) ) {s = 89;}

                         
                        input.seek(index75_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA75_1 = input.LA(1);

                         
                        int index75_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA75_2 = input.LA(1);

                         
                        int index75_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA75_3 = input.LA(1);

                         
                        int index75_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA75_4 = input.LA(1);

                         
                        int index75_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA75_5 = input.LA(1);

                         
                        int index75_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA75_6 = input.LA(1);

                         
                        int index75_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_6);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA75_7 = input.LA(1);

                         
                        int index75_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_7);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA75_8 = input.LA(1);

                         
                        int index75_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_8);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA75_9 = input.LA(1);

                         
                        int index75_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_9);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA75_10 = input.LA(1);

                         
                        int index75_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_10);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA75_11 = input.LA(1);

                         
                        int index75_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_11);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA75_12 = input.LA(1);

                         
                        int index75_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_12);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA75_13 = input.LA(1);

                         
                        int index75_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_13);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA75_14 = input.LA(1);

                         
                        int index75_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_14);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA75_15 = input.LA(1);

                         
                        int index75_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_15);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA75_16 = input.LA(1);

                         
                        int index75_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_16);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA75_17 = input.LA(1);

                         
                        int index75_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_17);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA75_18 = input.LA(1);

                         
                        int index75_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_18);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA75_19 = input.LA(1);

                         
                        int index75_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_19);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA75_20 = input.LA(1);

                         
                        int index75_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_20);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA75_21 = input.LA(1);

                         
                        int index75_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_21);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA75_22 = input.LA(1);

                         
                        int index75_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_22);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA75_23 = input.LA(1);

                         
                        int index75_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_23);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA75_24 = input.LA(1);

                         
                        int index75_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_24);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA75_25 = input.LA(1);

                         
                        int index75_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_25);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA75_26 = input.LA(1);

                         
                        int index75_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_26);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA75_27 = input.LA(1);

                         
                        int index75_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_27);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA75_28 = input.LA(1);

                         
                        int index75_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_28);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA75_29 = input.LA(1);

                         
                        int index75_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_29);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA75_30 = input.LA(1);

                         
                        int index75_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_30);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA75_31 = input.LA(1);

                         
                        int index75_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_31);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA75_32 = input.LA(1);

                         
                        int index75_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_32);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA75_33 = input.LA(1);

                         
                        int index75_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_33);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA75_34 = input.LA(1);

                         
                        int index75_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_34);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA75_35 = input.LA(1);

                         
                        int index75_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_35);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA75_36 = input.LA(1);

                         
                        int index75_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_36);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA75_37 = input.LA(1);

                         
                        int index75_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_37);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA75_38 = input.LA(1);

                         
                        int index75_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_38);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA75_39 = input.LA(1);

                         
                        int index75_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_39);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA75_40 = input.LA(1);

                         
                        int index75_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_40);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA75_41 = input.LA(1);

                         
                        int index75_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_41);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA75_42 = input.LA(1);

                         
                        int index75_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_42);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA75_43 = input.LA(1);

                         
                        int index75_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_43);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA75_44 = input.LA(1);

                         
                        int index75_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_44);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA75_45 = input.LA(1);

                         
                        int index75_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_45);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA75_46 = input.LA(1);

                         
                        int index75_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_46);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA75_47 = input.LA(1);

                         
                        int index75_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_47);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA75_48 = input.LA(1);

                         
                        int index75_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_48);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA75_49 = input.LA(1);

                         
                        int index75_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_49);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA75_50 = input.LA(1);

                         
                        int index75_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_50);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA75_76 = input.LA(1);

                         
                        int index75_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_76);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA75_77 = input.LA(1);

                         
                        int index75_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_77);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA75_78 = input.LA(1);

                         
                        int index75_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_78);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA75_79 = input.LA(1);

                         
                        int index75_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_79);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA75_80 = input.LA(1);

                         
                        int index75_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_80);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA75_81 = input.LA(1);

                         
                        int index75_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_81);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA75_82 = input.LA(1);

                         
                        int index75_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_82);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA75_83 = input.LA(1);

                         
                        int index75_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_83);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA75_84 = input.LA(1);

                         
                        int index75_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_84);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA75_85 = input.LA(1);

                         
                        int index75_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_85);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA75_86 = input.LA(1);

                         
                        int index75_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_86);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA75_87 = input.LA(1);

                         
                        int index75_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_87);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA75_88 = input.LA(1);

                         
                        int index75_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_88);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA75_89 = input.LA(1);

                         
                        int index75_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index75_89);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 75, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_41s = "\132\uffff";
    static final String dfa_42s = "\1\4\62\0\47\uffff";
    static final String dfa_43s = "\1\u008a\62\0\47\uffff";
    static final String dfa_44s = "\63\uffff\31\1\1\2\15\uffff";
    static final String dfa_45s = "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\47\uffff}>";
    static final String[] dfa_46s = {
            "\1\61\5\114\23\uffff\1\73\1\uffff\1\114\2\uffff\1\114\3\uffff\1\60\1\uffff\1\1\1\2\1\62\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\3\1\4\1\5\1\6\1\7\7\uffff\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\12\uffff\1\114\3\uffff\6\114",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final char[] dfa_43 = DFA.unpackEncodedStringToUnsignedChars(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final short[] dfa_45 = DFA.unpackEncodedString(dfa_45s);
    static final short[][] dfa_46 = unpackEncodedStringArray(dfa_46s);

    class DFA78 extends DFA {

        public DFA78(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 78;
            this.eot = dfa_41;
            this.eof = dfa_41;
            this.min = dfa_42;
            this.max = dfa_43;
            this.accept = dfa_44;
            this.special = dfa_45;
            this.transition = dfa_46;
        }
        public String getDescription() {
            return "4460:3: ( ( ( ( ( ( ruleValid_ID ) ) '::' ) | ( ( ( ( ruleDefinitionFacetKey | ruleTypeFacetKey | ruleSpecialFacetKey | ruleActionFacetKey ) ) ) ':' ) ) )=> ( ( ( (lv_op_0_0= ruleValid_ID ) ) otherlv_1= '::' ) | ( ( ( (lv_op_2_1= ruleDefinitionFacetKey | lv_op_2_2= ruleTypeFacetKey | lv_op_2_3= ruleSpecialFacetKey | lv_op_2_4= ruleActionFacetKey ) ) ) otherlv_3= ':' ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA78_0 = input.LA(1);

                         
                        int index78_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA78_0==40) ) {s = 1;}

                        else if ( (LA78_0==41) ) {s = 2;}

                        else if ( (LA78_0==83) ) {s = 3;}

                        else if ( (LA78_0==84) ) {s = 4;}

                        else if ( (LA78_0==85) ) {s = 5;}

                        else if ( (LA78_0==86) ) {s = 6;}

                        else if ( (LA78_0==87) ) {s = 7;}

                        else if ( (LA78_0==69) ) {s = 8;}

                        else if ( (LA78_0==70) ) {s = 9;}

                        else if ( (LA78_0==71) ) {s = 10;}

                        else if ( (LA78_0==72) ) {s = 11;}

                        else if ( (LA78_0==73) ) {s = 12;}

                        else if ( (LA78_0==74) ) {s = 13;}

                        else if ( (LA78_0==75) ) {s = 14;}

                        else if ( (LA78_0==76) ) {s = 15;}

                        else if ( (LA78_0==77) ) {s = 16;}

                        else if ( (LA78_0==78) ) {s = 17;}

                        else if ( (LA78_0==79) ) {s = 18;}

                        else if ( (LA78_0==80) ) {s = 19;}

                        else if ( (LA78_0==81) ) {s = 20;}

                        else if ( (LA78_0==82) ) {s = 21;}

                        else if ( (LA78_0==43) ) {s = 22;}

                        else if ( (LA78_0==44) ) {s = 23;}

                        else if ( (LA78_0==45) ) {s = 24;}

                        else if ( (LA78_0==46) ) {s = 25;}

                        else if ( (LA78_0==47) ) {s = 26;}

                        else if ( (LA78_0==48) ) {s = 27;}

                        else if ( (LA78_0==49) ) {s = 28;}

                        else if ( (LA78_0==50) ) {s = 29;}

                        else if ( (LA78_0==51) ) {s = 30;}

                        else if ( (LA78_0==52) ) {s = 31;}

                        else if ( (LA78_0==53) ) {s = 32;}

                        else if ( (LA78_0==54) ) {s = 33;}

                        else if ( (LA78_0==55) ) {s = 34;}

                        else if ( (LA78_0==56) ) {s = 35;}

                        else if ( (LA78_0==57) ) {s = 36;}

                        else if ( (LA78_0==58) ) {s = 37;}

                        else if ( (LA78_0==59) ) {s = 38;}

                        else if ( (LA78_0==60) ) {s = 39;}

                        else if ( (LA78_0==61) ) {s = 40;}

                        else if ( (LA78_0==62) ) {s = 41;}

                        else if ( (LA78_0==63) ) {s = 42;}

                        else if ( (LA78_0==64) ) {s = 43;}

                        else if ( (LA78_0==65) ) {s = 44;}

                        else if ( (LA78_0==66) ) {s = 45;}

                        else if ( (LA78_0==67) ) {s = 46;}

                        else if ( (LA78_0==68) ) {s = 47;}

                        else if ( (LA78_0==38) ) {s = 48;}

                        else if ( (LA78_0==RULE_ID) ) {s = 49;}

                        else if ( (LA78_0==42) ) {s = 50;}

                        else if ( (LA78_0==95) && (synpred11_InternalGaml())) {s = 51;}

                        else if ( (LA78_0==96) && (synpred11_InternalGaml())) {s = 52;}

                        else if ( (LA78_0==97) && (synpred11_InternalGaml())) {s = 53;}

                        else if ( (LA78_0==98) && (synpred11_InternalGaml())) {s = 54;}

                        else if ( (LA78_0==99) && (synpred11_InternalGaml())) {s = 55;}

                        else if ( (LA78_0==100) && (synpred11_InternalGaml())) {s = 56;}

                        else if ( (LA78_0==101) && (synpred11_InternalGaml())) {s = 57;}

                        else if ( (LA78_0==102) && (synpred11_InternalGaml())) {s = 58;}

                        else if ( (LA78_0==29) && (synpred11_InternalGaml())) {s = 59;}

                        else if ( (LA78_0==103) && (synpred11_InternalGaml())) {s = 60;}

                        else if ( (LA78_0==104) && (synpred11_InternalGaml())) {s = 61;}

                        else if ( (LA78_0==105) && (synpred11_InternalGaml())) {s = 62;}

                        else if ( (LA78_0==106) && (synpred11_InternalGaml())) {s = 63;}

                        else if ( (LA78_0==107) && (synpred11_InternalGaml())) {s = 64;}

                        else if ( (LA78_0==108) && (synpred11_InternalGaml())) {s = 65;}

                        else if ( (LA78_0==109) && (synpred11_InternalGaml())) {s = 66;}

                        else if ( (LA78_0==110) && (synpred11_InternalGaml())) {s = 67;}

                        else if ( (LA78_0==111) && (synpred11_InternalGaml())) {s = 68;}

                        else if ( (LA78_0==112) && (synpred11_InternalGaml())) {s = 69;}

                        else if ( (LA78_0==113) && (synpred11_InternalGaml())) {s = 70;}

                        else if ( (LA78_0==114) && (synpred11_InternalGaml())) {s = 71;}

                        else if ( (LA78_0==115) && (synpred11_InternalGaml())) {s = 72;}

                        else if ( (LA78_0==116) && (synpred11_InternalGaml())) {s = 73;}

                        else if ( (LA78_0==117) && (synpred11_InternalGaml())) {s = 74;}

                        else if ( (LA78_0==118) && (synpred11_InternalGaml())) {s = 75;}

                        else if ( ((LA78_0>=RULE_STRING && LA78_0<=RULE_KEYWORD)||LA78_0==31||LA78_0==34||LA78_0==129||(LA78_0>=133 && LA78_0<=138)) ) {s = 76;}

                         
                        input.seek(index78_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA78_1 = input.LA(1);

                         
                        int index78_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA78_2 = input.LA(1);

                         
                        int index78_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA78_3 = input.LA(1);

                         
                        int index78_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA78_4 = input.LA(1);

                         
                        int index78_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA78_5 = input.LA(1);

                         
                        int index78_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA78_6 = input.LA(1);

                         
                        int index78_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_6);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA78_7 = input.LA(1);

                         
                        int index78_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_7);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA78_8 = input.LA(1);

                         
                        int index78_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_8);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA78_9 = input.LA(1);

                         
                        int index78_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_9);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA78_10 = input.LA(1);

                         
                        int index78_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_10);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA78_11 = input.LA(1);

                         
                        int index78_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_11);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA78_12 = input.LA(1);

                         
                        int index78_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_12);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA78_13 = input.LA(1);

                         
                        int index78_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_13);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA78_14 = input.LA(1);

                         
                        int index78_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_14);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA78_15 = input.LA(1);

                         
                        int index78_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_15);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA78_16 = input.LA(1);

                         
                        int index78_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_16);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA78_17 = input.LA(1);

                         
                        int index78_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_17);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA78_18 = input.LA(1);

                         
                        int index78_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_18);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA78_19 = input.LA(1);

                         
                        int index78_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_19);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA78_20 = input.LA(1);

                         
                        int index78_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_20);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA78_21 = input.LA(1);

                         
                        int index78_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_21);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA78_22 = input.LA(1);

                         
                        int index78_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_22);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA78_23 = input.LA(1);

                         
                        int index78_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_23);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA78_24 = input.LA(1);

                         
                        int index78_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_24);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA78_25 = input.LA(1);

                         
                        int index78_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_25);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA78_26 = input.LA(1);

                         
                        int index78_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_26);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA78_27 = input.LA(1);

                         
                        int index78_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_27);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA78_28 = input.LA(1);

                         
                        int index78_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_28);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA78_29 = input.LA(1);

                         
                        int index78_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_29);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA78_30 = input.LA(1);

                         
                        int index78_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_30);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA78_31 = input.LA(1);

                         
                        int index78_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_31);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA78_32 = input.LA(1);

                         
                        int index78_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_32);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA78_33 = input.LA(1);

                         
                        int index78_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_33);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA78_34 = input.LA(1);

                         
                        int index78_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_34);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA78_35 = input.LA(1);

                         
                        int index78_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_35);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA78_36 = input.LA(1);

                         
                        int index78_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_36);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA78_37 = input.LA(1);

                         
                        int index78_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_37);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA78_38 = input.LA(1);

                         
                        int index78_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_38);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA78_39 = input.LA(1);

                         
                        int index78_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_39);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA78_40 = input.LA(1);

                         
                        int index78_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_40);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA78_41 = input.LA(1);

                         
                        int index78_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_41);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA78_42 = input.LA(1);

                         
                        int index78_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_42);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA78_43 = input.LA(1);

                         
                        int index78_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_43);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA78_44 = input.LA(1);

                         
                        int index78_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_44);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA78_45 = input.LA(1);

                         
                        int index78_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_45);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA78_46 = input.LA(1);

                         
                        int index78_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_46);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA78_47 = input.LA(1);

                         
                        int index78_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_47);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA78_48 = input.LA(1);

                         
                        int index78_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_48);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA78_49 = input.LA(1);

                         
                        int index78_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_49);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA78_50 = input.LA(1);

                         
                        int index78_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalGaml()) ) {s = 75;}

                        else if ( (true) ) {s = 76;}

                         
                        input.seek(index78_50);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 78, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_47s = "\1\4\62\0\2\uffff";
    static final String dfa_48s = "\1\127\62\0\2\uffff";
    static final String dfa_49s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\2\uffff}>";
    static final String[] dfa_50s = {
            "\1\61\41\uffff\1\60\1\uffff\1\1\1\2\1\62\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\3\1\4\1\5\1\6\1\7",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };
    static final char[] dfa_47 = DFA.unpackEncodedStringToUnsignedChars(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final short[] dfa_49 = DFA.unpackEncodedString(dfa_49s);
    static final short[][] dfa_50 = unpackEncodedStringArray(dfa_50s);

    class DFA104 extends DFA {

        public DFA104(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 104;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_47;
            this.max = dfa_48;
            this.accept = dfa_16;
            this.special = dfa_49;
            this.transition = dfa_50;
        }
        public String getDescription() {
            return "6019:2: ( ( ( ruleFunction )=>this_Function_0= ruleFunction ) | this_VariableRef_1= ruleVariableRef )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA104_1 = input.LA(1);

                         
                        int index104_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA104_2 = input.LA(1);

                         
                        int index104_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA104_3 = input.LA(1);

                         
                        int index104_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA104_4 = input.LA(1);

                         
                        int index104_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA104_5 = input.LA(1);

                         
                        int index104_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA104_6 = input.LA(1);

                         
                        int index104_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA104_7 = input.LA(1);

                         
                        int index104_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA104_8 = input.LA(1);

                         
                        int index104_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA104_9 = input.LA(1);

                         
                        int index104_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA104_10 = input.LA(1);

                         
                        int index104_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA104_11 = input.LA(1);

                         
                        int index104_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA104_12 = input.LA(1);

                         
                        int index104_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA104_13 = input.LA(1);

                         
                        int index104_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA104_14 = input.LA(1);

                         
                        int index104_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA104_15 = input.LA(1);

                         
                        int index104_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA104_16 = input.LA(1);

                         
                        int index104_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA104_17 = input.LA(1);

                         
                        int index104_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA104_18 = input.LA(1);

                         
                        int index104_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA104_19 = input.LA(1);

                         
                        int index104_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA104_20 = input.LA(1);

                         
                        int index104_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA104_21 = input.LA(1);

                         
                        int index104_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA104_22 = input.LA(1);

                         
                        int index104_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA104_23 = input.LA(1);

                         
                        int index104_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA104_24 = input.LA(1);

                         
                        int index104_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA104_25 = input.LA(1);

                         
                        int index104_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA104_26 = input.LA(1);

                         
                        int index104_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA104_27 = input.LA(1);

                         
                        int index104_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA104_28 = input.LA(1);

                         
                        int index104_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA104_29 = input.LA(1);

                         
                        int index104_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA104_30 = input.LA(1);

                         
                        int index104_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA104_31 = input.LA(1);

                         
                        int index104_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA104_32 = input.LA(1);

                         
                        int index104_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_32);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA104_33 = input.LA(1);

                         
                        int index104_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_33);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA104_34 = input.LA(1);

                         
                        int index104_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_34);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA104_35 = input.LA(1);

                         
                        int index104_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_35);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA104_36 = input.LA(1);

                         
                        int index104_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_36);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA104_37 = input.LA(1);

                         
                        int index104_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_37);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA104_38 = input.LA(1);

                         
                        int index104_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_38);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA104_39 = input.LA(1);

                         
                        int index104_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_39);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA104_40 = input.LA(1);

                         
                        int index104_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_40);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA104_41 = input.LA(1);

                         
                        int index104_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_41);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA104_42 = input.LA(1);

                         
                        int index104_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_42);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA104_43 = input.LA(1);

                         
                        int index104_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_43);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA104_44 = input.LA(1);

                         
                        int index104_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_44);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA104_45 = input.LA(1);

                         
                        int index104_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_45);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA104_46 = input.LA(1);

                         
                        int index104_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_46);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA104_47 = input.LA(1);

                         
                        int index104_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_47);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA104_48 = input.LA(1);

                         
                        int index104_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_48);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA104_49 = input.LA(1);

                         
                        int index104_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_49);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA104_50 = input.LA(1);

                         
                        int index104_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalGaml()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index104_50);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 104, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_51s = "\20\uffff";
    static final String dfa_52s = "\1\4\2\0\15\uffff";
    static final String dfa_53s = "\1\u0091\2\0\15\uffff";
    static final String dfa_54s = "\3\uffff\6\1\1\2\6\uffff";
    static final String dfa_55s = "\1\0\1\1\1\2\15\uffff}>";
    static final String[] dfa_56s = {
            "\1\1\13\uffff\2\11\1\uffff\1\11\3\uffff\1\10\11\uffff\1\7\6\uffff\1\2\1\3\1\11\52\uffff\1\4\1\5\1\6\7\uffff\2\11\60\uffff\1\11",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_51 = DFA.unpackEncodedString(dfa_51s);
    static final char[] dfa_52 = DFA.unpackEncodedStringToUnsignedChars(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final short[] dfa_54 = DFA.unpackEncodedString(dfa_54s);
    static final short[] dfa_55 = DFA.unpackEncodedString(dfa_55s);
    static final short[][] dfa_56 = unpackEncodedStringArray(dfa_56s);

    class DFA114 extends DFA {

        public DFA114(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 114;
            this.eot = dfa_51;
            this.eof = dfa_51;
            this.min = dfa_52;
            this.max = dfa_53;
            this.accept = dfa_54;
            this.special = dfa_55;
            this.transition = dfa_56;
        }
        public String getDescription() {
            return "6620:2: ( ( ( ruleS_Declaration )=>this_S_Declaration_0= ruleS_Declaration ) | (this_Model_1= ruleModel | this_ArgumentDefinition_2= ruleArgumentDefinition | this_DefinitionFacet_3= ruleDefinitionFacet | this_VarFakeDefinition_4= ruleVarFakeDefinition | this_Import_5= ruleImport | this_S_Experiment_6= ruleS_Experiment ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA114_0 = input.LA(1);

                         
                        int index114_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA114_0==RULE_ID) ) {s = 1;}

                        else if ( (LA114_0==40) ) {s = 2;}

                        else if ( (LA114_0==41) && (synpred14_InternalGaml())) {s = 3;}

                        else if ( (LA114_0==85) && (synpred14_InternalGaml())) {s = 4;}

                        else if ( (LA114_0==86) && (synpred14_InternalGaml())) {s = 5;}

                        else if ( (LA114_0==87) && (synpred14_InternalGaml())) {s = 6;}

                        else if ( (LA114_0==33) && (synpred14_InternalGaml())) {s = 7;}

                        else if ( (LA114_0==23) && (synpred14_InternalGaml())) {s = 8;}

                        else if ( ((LA114_0>=16 && LA114_0<=17)||LA114_0==19||LA114_0==42||(LA114_0>=95 && LA114_0<=96)||LA114_0==145) ) {s = 9;}

                         
                        input.seek(index114_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA114_1 = input.LA(1);

                         
                        int index114_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalGaml()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index114_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA114_2 = input.LA(1);

                         
                        int index114_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalGaml()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index114_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 114, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0xFFFFFF44A00003F0L,0x007FFFFF80FFFFFFL,0x00000000000007E2L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0xFFFFFF4000420010L,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0xFFFFFF4000400012L,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0xFFFFFF4000000010L,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0xFFFFFF4000000030L,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0xFFFFFF4420308010L,0x00FFFFFF80FFFFFFL});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0xFFFFFF4420208010L,0x00FFFFFF80FFFFFFL});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0xFFFFFF4420008010L,0x00FFFFFF80FFFFFFL});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xFFFFFF44A02003F0L,0x007FFFFF80FFFFFFL,0x00000000000007E2L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xFFFFFF4420000010L,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000420000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0xFFFFFF44A0208010L,0x00FFFFFF80FFFFFFL});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000008000L,0x000000003F000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0xFFFFFF4020208010L,0x00FFFFFF80FFFFFFL});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0xFFFFFF4800000010L,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0xFFFFFB0800000000L,0x000000000007FFFFL});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0xFFFFFF4400000010L,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0xFFFFFFEEB58003F0L,0x007FFFFF80FFFFFFL,0x00000000000007E2L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000002L,0x0100000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0200000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000010080000010L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000001000000002L,0xF000000002000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0xFFFFFF4000000012L,0x0000000000FFFFFFL});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000001400L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0xFFFFFF44A00003F0L,0x007FFFFF80FFFFFFL,0x0000000000000FE2L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000800000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000080000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0xFFFFFF45A00003F0L,0x007FFFFF80FFFFFFL,0x00000000000007E2L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000042000000L});

}