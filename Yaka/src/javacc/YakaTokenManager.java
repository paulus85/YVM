/* Generated By:JavaCC: Do not edit this line. YakaTokenManager.java */
package javacc;
import classes.*;

/** Token Manager. */
public class YakaTokenManager implements YakaConstants
{
 public static String identLu,chaineLue;
 public static int entierLu;

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x7ffffff00L) != 0L)
         {
            jjmatchedKind = 38;
            return 2;
         }
         return -1;
      case 1:
         if ((active0 & 0xc02800L) != 0L)
            return 2;
         if ((active0 & 0x7ff3fd700L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 38;
               jjmatchedPos = 1;
            }
            return 2;
         }
         return -1;
      case 2:
         if ((active0 & 0x1004200L) != 0L)
            return 2;
         if ((active0 & 0x7fe3f9d00L) != 0L)
         {
            jjmatchedKind = 38;
            jjmatchedPos = 2;
            return 2;
         }
         return -1;
      case 3:
         if ((active0 & 0x200321000L) != 0L)
            return 2;
         if ((active0 & 0x5fe0d8d00L) != 0L)
         {
            jjmatchedKind = 38;
            jjmatchedPos = 3;
            return 2;
         }
         return -1;
      case 4:
         if ((active0 & 0x80080c00L) != 0L)
            return 2;
         if ((active0 & 0x57e058100L) != 0L)
         {
            jjmatchedKind = 38;
            jjmatchedPos = 4;
            return 2;
         }
         return -1;
      case 5:
         if ((active0 & 0x100008000L) != 0L)
            return 2;
         if ((active0 & 0x47e050100L) != 0L)
         {
            jjmatchedKind = 38;
            jjmatchedPos = 5;
            return 2;
         }
         return -1;
      case 6:
         if ((active0 & 0x47e010000L) != 0L)
         {
            jjmatchedKind = 38;
            jjmatchedPos = 6;
            return 2;
         }
         if ((active0 & 0x40100L) != 0L)
            return 2;
         return -1;
      case 7:
         if ((active0 & 0x7c000000L) != 0L)
         {
            jjmatchedKind = 38;
            jjmatchedPos = 7;
            return 2;
         }
         if ((active0 & 0x402010000L) != 0L)
            return 2;
         return -1;
      case 8:
         if ((active0 & 0x2c000000L) != 0L)
            return 2;
         if ((active0 & 0x50000000L) != 0L)
         {
            jjmatchedKind = 38;
            jjmatchedPos = 8;
            return 2;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 40:
         jjmatchedKind = 40;
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 41:
         return jjStopAtPos(0, 42);
      case 42:
         return jjStopAtPos(0, 52);
      case 43:
         return jjStopAtPos(0, 50);
      case 44:
         return jjStopAtPos(0, 41);
      case 45:
         return jjStopAtPos(0, 51);
      case 47:
         return jjStopAtPos(0, 53);
      case 59:
         return jjStopAtPos(0, 43);
      case 60:
         jjmatchedKind = 46;
         return jjMoveStringLiteralDfa1_0(0xa00000000000L);
      case 61:
         return jjStopAtPos(0, 44);
      case 62:
         jjmatchedKind = 48;
         return jjMoveStringLiteralDfa1_0(0x2000000000000L);
      case 65:
         return jjMoveStringLiteralDfa1_0(0x480000000L);
      case 66:
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 67:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 69:
         return jjMoveStringLiteralDfa1_0(0x100808000L);
      case 70:
         return jjMoveStringLiteralDfa1_0(0x56304400L);
      case 76:
         return jjMoveStringLiteralDfa1_0(0x200000000L);
      case 78:
         return jjMoveStringLiteralDfa1_0(0x1000000L);
      case 79:
         return jjMoveStringLiteralDfa1_0(0x400000L);
      case 80:
         return jjMoveStringLiteralDfa1_0(0x28001000L);
      case 82:
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 83:
         return jjMoveStringLiteralDfa1_0(0x2800L);
      case 84:
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 86:
         return jjMoveStringLiteralDfa1_0(0x20200L);
      default :
         return jjMoveNfa_0(1, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 42:
         if ((active0 & 0x20L) != 0L)
            return jjStopAtPos(1, 5);
         break;
      case 61:
         if ((active0 & 0x800000000000L) != 0L)
            return jjStopAtPos(1, 47);
         else if ((active0 & 0x2000000000000L) != 0L)
            return jjStopAtPos(1, 49);
         break;
      case 62:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStopAtPos(1, 45);
         break;
      case 65:
         return jjMoveStringLiteralDfa2_0(active0, 0x340600L);
      case 67:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000L);
      case 69:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000L);
      case 70:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000L);
      case 73:
         if ((active0 & 0x2000L) != 0L)
         {
            jjmatchedKind = 13;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x200000800L);
      case 76:
         return jjMoveStringLiteralDfa2_0(active0, 0x480000000L);
      case 78:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000L);
      case 79:
         return jjMoveStringLiteralDfa2_0(active0, 0x3081100L);
      case 80:
         return jjMoveStringLiteralDfa2_0(active0, 0x50000000L);
      case 82:
         return jjMoveStringLiteralDfa2_0(active0, 0x28020000L);
      case 83:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000L);
      case 84:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(1, 23, 2);
         break;
      case 85:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(1, 22, 2);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa3_0(active0, 0x400020000L);
      case 73:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(2, 14, 2);
         return jjMoveStringLiteralDfa3_0(active0, 0x20200400L);
      case 78:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(2, 24, 2);
         return jjMoveStringLiteralDfa3_0(active0, 0x20c0800L);
      case 79:
         return jjMoveStringLiteralDfa3_0(active0, 0x8c000100L);
      case 82:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(2, 9, 2);
         return jjMoveStringLiteralDfa3_0(active0, 0x350000000L);
      case 84:
         return jjMoveStringLiteralDfa3_0(active0, 0x18000L);
      case 85:
         return jjMoveStringLiteralDfa3_0(active0, 0x101000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 67:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000L);
      case 69:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(3, 33, 2);
         break;
      case 71:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000L);
      case 73:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(3, 17, 2);
         return jjMoveStringLiteralDfa4_0(active0, 0x140008000L);
      case 76:
         return jjMoveStringLiteralDfa4_0(active0, 0x400000100L);
      case 78:
         return jjMoveStringLiteralDfa4_0(active0, 0x24000000L);
      case 79:
         return jjMoveStringLiteralDfa4_0(active0, 0x10010800L);
      case 82:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(3, 12, 2);
         return jjMoveStringLiteralDfa4_0(active0, 0x80000400L);
      case 83:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000L);
      case 84:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(3, 21, 2);
         return jjMoveStringLiteralDfa4_0(active0, 0x40000L);
      case 88:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(3, 20, 2);
         break;
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 67:
         return jjMoveStringLiteralDfa5_0(active0, 0x24000000L);
      case 69:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 2);
         return jjMoveStringLiteralDfa5_0(active0, 0x8100L);
      case 71:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000000L);
      case 73:
         return jjMoveStringLiteralDfa5_0(active0, 0x400000000L);
      case 78:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(4, 11, 2);
         return jjMoveStringLiteralDfa5_0(active0, 0x40000000L);
      case 81:
         return jjMoveStringLiteralDfa5_0(active0, 0x40000L);
      case 82:
         return jjMoveStringLiteralDfa5_0(active0, 0x108000000L);
      case 83:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(4, 31, 2);
         break;
      case 84:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(4, 19, 2);
         return jjMoveStringLiteralDfa5_0(active0, 0x2000000L);
      case 85:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000L);
      case 67:
         return jjMoveStringLiteralDfa6_0(active0, 0x40000000L);
      case 69:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(5, 32, 2);
         return jjMoveStringLiteralDfa6_0(active0, 0x100L);
      case 71:
         return jjMoveStringLiteralDfa6_0(active0, 0x400000000L);
      case 73:
         return jjMoveStringLiteralDfa6_0(active0, 0x22000000L);
      case 82:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(5, 15, 2);
         return jjMoveStringLiteralDfa6_0(active0, 0x10010000L);
      case 84:
         return jjMoveStringLiteralDfa6_0(active0, 0x4000000L);
      case 85:
         return jjMoveStringLiteralDfa6_0(active0, 0x40000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa7_0(active0, 0x10000000L);
      case 69:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(6, 18, 2);
         break;
      case 73:
         return jjMoveStringLiteralDfa7_0(active0, 0x44000000L);
      case 77:
         return jjMoveStringLiteralDfa7_0(active0, 0x8000000L);
      case 78:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(6, 8, 2);
         return jjMoveStringLiteralDfa7_0(active0, 0x400010000L);
      case 79:
         return jjMoveStringLiteralDfa7_0(active0, 0x2000000L);
      case 80:
         return jjMoveStringLiteralDfa7_0(active0, 0x20000000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa8_0(active0, 0x20000000L);
      case 69:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(7, 16, 2);
         else if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(7, 34, 2);
         break;
      case 77:
         return jjMoveStringLiteralDfa8_0(active0, 0x18000000L);
      case 78:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(7, 25, 2);
         break;
      case 79:
         return jjMoveStringLiteralDfa8_0(active0, 0x4000000L);
      case 80:
         return jjMoveStringLiteralDfa8_0(active0, 0x40000000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa9_0(active0, 0x40000000L);
      case 69:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(8, 27, 2);
         break;
      case 76:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(8, 29, 2);
         break;
      case 77:
         return jjMoveStringLiteralDfa9_0(active0, 0x10000000L);
      case 78:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(8, 26, 2);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
static private int jjMoveStringLiteralDfa9_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0);
      return 9;
   }
   switch(curChar)
   {
      case 69:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(9, 28, 2);
         break;
      case 76:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(9, 30, 2);
         break;
      default :
         break;
   }
   return jjStartNfa_0(8, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 9;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 36)
                        kind = 36;
                     jjCheckNAdd(0);
                  }
                  else if (curChar == 39)
                     jjCheckNAddTwoStates(7, 8);
                  else if (curChar == 34)
                     jjCheckNAddTwoStates(4, 5);
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 36)
                     kind = 36;
                  jjCheckNAdd(0);
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 38)
                     kind = 38;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 3:
                  if (curChar == 34)
                     jjCheckNAddTwoStates(4, 5);
                  break;
               case 4:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(4, 5);
                  break;
               case 5:
                  if (curChar == 34 && kind > 39)
                     kind = 39;
                  break;
               case 6:
                  if (curChar == 39)
                     jjCheckNAddTwoStates(7, 8);
                  break;
               case 7:
                  if ((0xffffff7fffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(7, 8);
                  break;
               case 8:
                  if (curChar == 39 && kind > 39)
                     kind = 39;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
               case 2:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 38)
                     kind = 38;
                  jjCheckNAdd(2);
                  break;
               case 4:
                  jjAddStates(0, 1);
                  break;
               case 7:
                  jjAddStates(2, 3);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(0, 1);
                  break;
               case 7:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(2, 3);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 9 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static private int jjMoveStringLiteralDfa0_1()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_1(0x80L);
      default :
         return 1;
   }
}
static private int jjMoveStringLiteralDfa1_1(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 41:
         if ((active0 & 0x80L) != 0L)
            return jjStopAtPos(1, 7);
         break;
      default :
         return 2;
   }
   return 2;
}
static final int[] jjnextStates = {
   4, 5, 7, 8, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, "\102\117\117\114\105\105\116", 
"\126\101\122", "\106\101\111\122\105", "\123\111\116\117\116", "\120\117\125\122", 
"\123\111", "\106\123\111", "\105\116\124\111\105\122", 
"\122\105\124\117\125\122\116\105", "\126\122\101\111", "\124\101\116\124\121\125\105", "\103\117\116\123\124", 
"\106\101\125\130", "\106\101\111\124", "\117\125", "\105\124", "\116\117\116", 
"\106\117\116\103\124\111\117\116", "\106\106\117\116\103\124\111\117\116", 
"\120\122\117\107\122\101\115\115\105", "\106\120\122\117\107\122\101\115\115\105", 
"\120\122\111\116\103\111\120\101\114", "\106\120\122\111\116\103\111\120\101\114", "\101\114\117\122\123", 
"\105\103\122\111\122\105", "\114\111\122\105", "\101\114\101\114\111\107\116\105", null, null, null, null, 
null, "\50", "\54", "\51", "\73", "\75", "\74\76", "\74", "\74\75", "\76", "\76\75", 
"\53", "\55", "\52", "\57", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "IN_COMMENT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0x3fffd7ffffff01L, 
};
static final long[] jjtoSkip = {
   0xbeL, 
};
static final long[] jjtoMore = {
   0x40L, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[9];
static private final int[] jjstateSet = new int[18];
private static final StringBuilder jjimage = new StringBuilder();
private static StringBuilder image = jjimage;
private static int jjimageLen;
private static int lengthOfMatch;
static protected char curChar;
/** Constructor. */
public YakaTokenManager(SimpleCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}

/** Constructor. */
public YakaTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 9; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
static public void SwitchTo(int lexState)
{
   if (lexState >= 2 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   for (;;)
   {
     switch(curLexState)
     {
       case 0:
         try { input_stream.backup(0);
            while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
               curChar = input_stream.BeginToken();
         }
         catch (java.io.IOException e1) { continue EOFLoop; }
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_0();
         break;
       case 1:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_1();
         if (jjmatchedPos == 0 && jjmatchedKind > 6)
         {
            jjmatchedKind = 6;
         }
         break;
     }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
           TokenLexicalActions(matchedToken);
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           SkipLexicalActions(null);
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
        jjimageLen += jjmatchedPos + 1;
      if (jjnewLexState[jjmatchedKind] != -1)
        curLexState = jjnewLexState[jjmatchedKind];
        curPos = 0;
        jjmatchedKind = 0x7fffffff;
        try {
           curChar = input_stream.readChar();
           continue;
        }
        catch (java.io.IOException e1) { }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
   }
  }
}

static void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 7 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
              SwitchTo(DEFAULT);
         break;
      default :
         break;
   }
}
static void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 36 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
          entierLu = Integer.parseInt(image.toString());
         break;
      case 38 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
         identLu =image.toString();
         break;
      case 39 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
          chaineLue = image.toString();
         break;
      default :
         break;
   }
}
static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

}
