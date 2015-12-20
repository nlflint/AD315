import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by nate on 12/14/15.
 */
public class States {
    public static ArrayList<State> SimpleAlternatingSequence() {

        State first = new State(
                "b"
                ,Predicates.Equals("")
                , ConsolidateActions(Actions.Print("0"))
                ,"b" );

        State second = new State(
                "b"
                , Predicates.Equals("0")
                , ConsolidateActions(Actions.Right, Actions.Right, Actions.Print("1"))
                , "b" );

        State third = new State(
                "b"
                ,Predicates.Equals("1")
                , ConsolidateActions(Actions.Right ,Actions.Right ,Actions.Print("0"))
                ,"b" );

        return new ArrayList<State>(Arrays.asList(first, second, third));
    }

    public static ArrayList<State> CountingSequence() {

        State initial = new State(
                "b"
                ,Predicates.Blank
                ,ConsolidateActions(
                    Actions.Print("ə")
                    ,Actions.Right
                    ,Actions.Print("ə")
                    ,Actions.Right
                    ,Actions.Print("0")
                    ,Actions.Right
                    ,Actions.Right
                    ,Actions.Print("0")
                    ,Actions.Left
                    ,Actions.Left)
                ,"o" );

        State firsto = new State(
                "o"
                , Predicates.Equals("1")
                , ConsolidateActions(Actions.Right, Actions.Print("x"), Actions.Left, Actions.Left, Actions.Left)
                , "o" );

        State secondo = new State(
                "o"
                ,Predicates.Equals("0")
                ,ConsolidateActions()
                ,"q" );

        State firstq = new State(
                "q"
                ,Predicates.NotBlank
                ,ConsolidateActions(Actions.Right ,Actions.Right)
                ,"q" );

        State secondq = new State(
                "q"
                ,Predicates.Equals("")
                ,ConsolidateActions(Actions.Print("1"), Actions.Left)
                ,"p" );


        State firstp = new State(
                "p"
                ,Predicates.Equals("x")
                , ConsolidateActions(Actions.Erase, Actions.Right)
                ,"q" );

        State secondp = new State(
                "p"
                ,Predicates.Equals("ə")
                , ConsolidateActions(Actions.Right)
                ,"f" );

        State thirdp = new State(
                "p"
                ,Predicates.Equals("")
                , ConsolidateActions(Actions.Left, Actions.Left)
                ,"p" );

        State firstf = new State(
                "f"
                ,Predicates.NotBlank
                , ConsolidateActions(Actions.Right, Actions.Right)
                ,"f" );

        State secondf = new State(
                "f"
                ,Predicates.Equals("")
                , ConsolidateActions(Actions.Print("0"), Actions.Left, Actions.Left)
                ,"o" );

        return new ArrayList<State>(Arrays.asList(initial, firsto, secondo, firstq, secondq, firstp,
        secondp, thirdp, firstf, secondf));
    }

    private static ArrayList<IAction> ConsolidateActions(IAction... actions) {
        return new ArrayList<IAction>(Arrays.asList(actions));
    }
}
