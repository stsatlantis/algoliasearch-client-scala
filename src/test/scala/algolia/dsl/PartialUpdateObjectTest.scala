/*
 * Copyright (c) 2015 Algolia
 * http://www.algolia.com/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package algolia.dsl

import algolia.AlgoliaDsl._
import algolia.AlgoliaTest
import algolia.http.{HttpPayload, POST}

class PartialUpdateObjectTest extends AlgoliaTest {

  describe("increment value") {

    it("should increment") {
      increment ofObjectId "myId" attribute "toto" by 1 from "index"
    }

    it("should call API") {
      (increment ofObjectId "myId" attribute "toto" by 1 from "index").build() should be(
        HttpPayload(
          POST,
          Seq("1", "indexes", "index", "myId", "partial"),
          body = Some("{\"toto\":{\"_operation\":\"Increment\",\"value\":1}}"),
          isSearch = false
        )
      )
    }

  }

  describe("decrement value") {

    it("should increment") {
      decrement attribute "toto" by 1 ofObjectId "myId" from "index"
    }

    it("should call API") {
      (decrement attribute "toto" by 1 ofObjectId "myId" from "index").build() should be(
        HttpPayload(
          POST,
          Seq("1", "indexes", "index", "myId", "partial"),
          body = Some("{\"toto\":{\"_operation\":\"Decrement\",\"value\":1}}"),
          isSearch = false
        )
      )
    }

  }

  describe("add value") {

    it("should add value") {
      add inAttribute "toto" value "truc" ofObjectId "myId" from "index"
    }

    it("should call API") {
      (add inAttribute "toto" value "truc" ofObjectId "myId" from "index").build() should be(
        HttpPayload(
          POST,
          Seq("1", "indexes", "index", "myId", "partial"),
          body = Some("{\"toto\":{\"_operation\":\"Add\",\"value\":\"truc\"}}"),
          isSearch = false
        )
      )
    }

  }

  describe("remove value") {

    it("remove add value") {
      remove inAttribute "toto" value "truc" ofObjectId "myId" from "index"
    }

    it("should call API") {
      (remove inAttribute "toto" value "truc" ofObjectId "myId" from "index").build() should be(
        HttpPayload(
          POST,
          Seq("1", "indexes", "index", "myId", "partial"),
          body = Some("{\"toto\":{\"_operation\":\"Remove\",\"value\":\"truc\"}}"),
          isSearch = false
        )
      )
    }

  }

  describe("addUnique value") {

    it("should add unique value") {
      addUnique inAttribute "toto" value "truc" ofObjectId "myId" from "index"
    }

    it("should call API") {
      (addUnique inAttribute "toto" value "truc" ofObjectId "myId" from "index").build() should be(
        HttpPayload(
          POST,
          Seq("1", "indexes", "index", "myId", "partial"),
          body = Some("{\"toto\":{\"_operation\":\"AddUnique\",\"value\":\"truc\"}}"),
          isSearch = false
        )
      )
    }

  }

  describe("update one field") {

    it("should update one field") {
      update attribute "toto" value "truc" ofObjectId "myId" from "index"
    }

    it("should call API") {
      (update attribute "toto" value "truc" ofObjectId "myId" from "index").build() should be(
        HttpPayload(
          POST,
          Seq("1", "indexes", "index", "myId", "partial"),
          body = Some("{\"toto\":\"truc\"}"),
          isSearch = false
        )
      )
    }

  }


}
