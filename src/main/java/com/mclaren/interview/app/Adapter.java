package com.mclaren.interview.app;

interface Adapter<IN, OUT>
{
  OUT convert(IN value);
}
